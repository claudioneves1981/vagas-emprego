package com.vagasemprego.demo.controllers;

import com.vagasemprego.demo.dtos.SessaoDTO;
import com.vagasemprego.demo.dtos.UserRequestDTO;
import com.vagasemprego.demo.dtos.UserResponseDTO;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.services.SessaoService;
import com.vagasemprego.demo.services.UsuarioService;
import com.vagasemprego.demo.services.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VagasService vagasService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> userResponseDTOList = usuarioService.findAll();
        return ResponseEntity.ok(userResponseDTOList);
    }

    @GetMapping("/{usuario}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDTO> findByUsuario(@PathVariable String usuario) {
        UserResponseDTO userResponseDTO = usuarioService.findByUsuario(usuario);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO userDTO) {
        UserResponseDTO userResponseDTO = usuarioService.update(id, userDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
