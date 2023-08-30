package com.vagasemprego.demo.services;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;


    public void createUser(Usuario user) {
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
        usuarioRepository.save(user);
    }

    public Usuario findByUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}