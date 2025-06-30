package com.vagasemprego.demo.controllers;

import com.vagasemprego.demo.dtos.SessaoDTO;
import com.vagasemprego.demo.dtos.UserRequestDTO;
import com.vagasemprego.demo.dtos.UserResponseDTO;
import com.vagasemprego.demo.security.JWTCreator;
import com.vagasemprego.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTCreator jwtCreator;

    @PostMapping("/login")
    public ResponseEntity<SessaoDTO> logar(@RequestBody UserRequestDTO login) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.username(), login.password()));
        String token = jwtCreator.generateToken(authentication);
        String refreshToken = jwtCreator.generateRefreshToken(authentication);
        return ResponseEntity.ok(new SessaoDTO(token, refreshToken));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = service.create(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }
}
