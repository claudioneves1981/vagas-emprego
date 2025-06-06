package com.vagasemprego.demo.controllers;

import com.vagasemprego.demo.dtos.SessaoDTO;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.services.SessaoService;
import com.vagasemprego.demo.services.UsuarioService;
import com.vagasemprego.demo.services.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VagasService vagasService;

    @Autowired
    private SessaoService sessaoService;

    @GetMapping("/users")
    public List<Usuario> users(){
        return usuarioService.findAll();
    }

    @GetMapping("users/{usuario}/vagas/situacao/{situacao}")
    public ResponseEntity<Usuario> situacao(@PathVariable("usuario") String usuario, @PathVariable("situacao")String situacao){

        Usuario usuarioTemp = usuarioService.findBySituacao(usuario,situacao);

        if (usuarioTemp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return ResponseEntity.status(HttpStatus.FOUND)
                .body(usuarioTemp);

    }

    @GetMapping("/users/{usuario}/vagas/tipo/{tipo}")
    public ResponseEntity<Usuario> tipo(@PathVariable("usuario") String usuario, @PathVariable("tipo")String tipo){
        Usuario usuarioTemp = usuarioService.findByTipo(usuario,tipo);


        if (usuarioTemp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return ResponseEntity.status(HttpStatus.FOUND)
                .body(usuarioTemp);
    }

    @GetMapping("/users/{usuario}/vagas/contrato/{contrato}")
    public ResponseEntity<Usuario> contrato(@PathVariable("usuario") String usuario, @PathVariable("contrato")String contrato){
        Usuario usuarioTemp = usuarioService.findByContrato(usuario,contrato);


        if (usuarioTemp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return ResponseEntity.status(HttpStatus.FOUND)
                .body(usuarioTemp);
    }


    @GetMapping("/users/{usuario}/vagas/interesse/{interesse}")
    public ResponseEntity<Usuario> interesse(@PathVariable("usuario") String usuario, @PathVariable("interesse")String interesse){
        Usuario usuarioTemp = usuarioService.findByInteresse(usuario,interesse);


        if (usuarioTemp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return ResponseEntity.status(HttpStatus.FOUND)
                .body(usuarioTemp);
    }


    @GetMapping("/users/{usuario}/vagas")
    public Usuario usuario(@PathVariable("usuario") String usuario){
        return usuarioService.findByUsuario(usuario);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody Usuario user){
        usuarioService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public void atualizar(@RequestBody Usuario user, @PathVariable("id") Long id){
        if(user.getId() != null){
            usuarioService.atualizar(user,id);
        }
    }
}
