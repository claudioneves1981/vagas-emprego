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

import java.util.ArrayList;
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

    public Usuario findBySituacao(String usuario, String situacao) {
        Usuario user = usuarioRepository.findByUsuario(usuario);
        Usuario replaceuser = new Usuario();
        List<Vagas> vagas = user.getVagas();
        List<Vagas> replacevagas = new ArrayList<>();
        for (Vagas vaga : vagas) {
            if (vaga.getSituacao().equals(Situacao.valueOf(situacao.toUpperCase()))) {
                replacevagas.add(vaga);
            }
        }
        replaceuser.setUsuario(user.getUsuario());
        replaceuser.setRoles(user.getRoles());
        replaceuser.setId(user.getId());
        replaceuser.setPassword(user.getPassword());
        replaceuser.setVagas(replacevagas);

        return replaceuser;
    }

    public Usuario findByTipo(String usuario, String tipo){
        Usuario user = usuarioRepository.findByUsuario(usuario);
        Usuario replaceuser = new Usuario();
        List<Vagas> vagas = user.getVagas();
        List<Vagas> replacevagas = new ArrayList<>();
        for (Vagas vaga : vagas) {
            if (vaga.getTipo().equals(Tipo.valueOf(tipo.toUpperCase()))) {
                replacevagas.add(vaga);
            }
        }
        replaceuser.setUsuario(user.getUsuario());
        replaceuser.setRoles(user.getRoles());
        replaceuser.setId(user.getId());
        replaceuser.setPassword(user.getPassword());
        replaceuser.setVagas(replacevagas);

        return replaceuser;
    }

    public Usuario findByContrato(String usuario, String contrato){
        Usuario user = usuarioRepository.findByUsuario(usuario);
        Usuario replaceuser = new Usuario();
        List<Vagas> vagas = user.getVagas();
        List<Vagas> replacevagas = new ArrayList<>();
        for (Vagas vaga : vagas) {
            if (vaga.getContrato().equals(Contrato.valueOf(contrato.toUpperCase()))) {
                replacevagas.add(vaga);
            }
        }
        replaceuser.setUsuario(user.getUsuario());
        replaceuser.setRoles(user.getRoles());
        replaceuser.setId(user.getId());
        replaceuser.setPassword(user.getPassword());
        replaceuser.setVagas(replacevagas);

        return replaceuser;    }

    public Usuario findByInteresse(String usuario, String interesse){
        Usuario user = usuarioRepository.findByUsuario(usuario);
        Usuario replaceuser = new Usuario();
        List<Vagas> vagas = user.getVagas();
        List<Vagas> replacevagas = new ArrayList<>();
        for (Vagas vaga : vagas) {
            if (vaga.getInteresse().equals(Interesse.valueOf(interesse.toUpperCase()))) {
                replacevagas.add(vaga);
            }
        }
        replaceuser.setUsuario(user.getUsuario());
        replaceuser.setRoles(user.getRoles());
        replaceuser.setId(user.getId());
        replaceuser.setPassword(user.getPassword());
        replaceuser.setVagas(replacevagas);

        return replaceuser;

    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

}