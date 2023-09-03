package com.vagasemprego.demo.services;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.models.enuns.Contrato;
import com.vagasemprego.demo.models.enuns.Interesse;
import com.vagasemprego.demo.models.enuns.Situacao;
import com.vagasemprego.demo.models.enuns.Tipo;
import com.vagasemprego.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;


    public void createUser(Usuario user) {
        String pass = user.getPassword();
        List<Vagas> vagas = user.getVagas();
        System.out.print(vagas);
        user.setVagas(vagas);
        user.setPassword(encoder.encode(pass));
        usuarioRepository.save(user);
    }

    public Usuario findByUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public Usuario findBySituacao(String usuario, String situacao){
        return usuarioRepository.findBySituacao(usuario, Situacao.valueOf(situacao.toUpperCase()));
    }

    public Usuario findByTipo(String usuario, String tipo){
        return usuarioRepository.findByTipo(usuario, Tipo.valueOf(tipo.toUpperCase()));
    }

    public Usuario findByContrato(String usuario, String contrato){
        return usuarioRepository.findByContrato(usuario, Contrato.valueOf(contrato.toUpperCase()));
    }

    public Usuario findByInteresse(String usuario, String interesse){
        return usuarioRepository.findByInteresse(usuario, Interesse.valueOf(interesse.toUpperCase()));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

}