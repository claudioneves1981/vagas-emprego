package com.vagasemprego.demo.services;

import com.vagasemprego.demo.dtos.LoginDTO;
import com.vagasemprego.demo.dtos.SessaoDTO;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.repositories.UsuarioRepository;
import com.vagasemprego.demo.security.JWTCreator;
import com.vagasemprego.demo.security.JWTObject;
import com.vagasemprego.demo.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SessaoService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public SessaoDTO getSessao(String usuario, String password){

        Usuario user = usuarioRepository.findByUsuario(usuario);

        if (user != null) {
            boolean passwordOk = encoder.matches(password, user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha invalida para o login:" + password);
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
