package com.vagasemprego.demo.controllers;

import com.vagasemprego.demo.dtos.LoginDTO;
import com.vagasemprego.demo.dtos.SessaoDTO;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.repositories.UsuarioRepository;
import com.vagasemprego.demo.security.JWTCreator;
import com.vagasemprego.demo.security.JWTObject;
import com.vagasemprego.demo.security.SecurityConfig;
import com.vagasemprego.demo.services.SessaoService;
import com.vagasemprego.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<SessaoDTO> logar(@RequestBody LoginDTO login) {

        SessaoDTO sessao = sessaoService.getSessao(login.getUsername(), login.getPassword());

        return ResponseEntity.status(HttpStatus.OK)
                .body(sessao);
    }
}
