package com.vagasemprego.demo.controllers;

import com.vagasemprego.demo.dtos.LoginDTO;
import com.vagasemprego.demo.dtos.SessaoDTO;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.repositories.UsuarioRepository;
import com.vagasemprego.demo.security.JWTCreator;
import com.vagasemprego.demo.security.JWTObject;
import com.vagasemprego.demo.security.SecurityConfig;
import com.vagasemprego.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public SessaoDTO logar(@RequestBody LoginDTO login) {
        Usuario user = service.findByUsuario(login.getUsername());
        if (user != null) {
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha invalida para o login:" + login.getUsername());
            }
            SessaoDTO sessao = new SessaoDTO();
            sessao.setLogin(user.getUsuario());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        } else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
