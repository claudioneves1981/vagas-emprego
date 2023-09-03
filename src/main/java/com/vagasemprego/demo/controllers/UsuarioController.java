package com.vagasemprego.demo.controllers;

import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.services.UsuarioService;
import com.vagasemprego.demo.services.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VagasService vagasService;

    @GetMapping("/users")
    public List<Usuario> users(){
        return usuarioService.findAll();
    }

    @GetMapping("/users/{usuario}/vagas/situacao/{situacao}")
    public Usuario situacao(@PathVariable("usuario") String usuario, @PathVariable("situacao")String situacao){
        return usuarioService.findBySituacao(usuario,situacao);
    }

    @GetMapping("/users/{usuario}/vagas/tipo/{tipo}")
    public Usuario tipo(@PathVariable("usuario") String usuario, @PathVariable("tipo")String tipo){
        return usuarioService.findByTipo(usuario,tipo);
    }

    @GetMapping("/users/{usuario}/vagas/contrato/{contrato}")
    public Usuario contrato(@PathVariable("usuario") String usuario, @PathVariable("contrato")String contrato){
        return usuarioService.findByContrato(usuario,contrato);
    }

    @GetMapping("/users/{usuario}/vagas/interesse/{interesse}")
    public Usuario interesse(@PathVariable("usuario") String usuario, @PathVariable("interesse")String interesse){
        return usuarioService.findByInteresse(usuario,interesse);
    }

    @GetMapping("/users/{usuario}/vagas")
    public Usuario usuario(@PathVariable("usuario") String usuario){
        return usuarioService.findByUsuario(usuario);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody Usuario user){
        usuarioService.createUser(user);
    }

    @DeleteMapping("/users/{usuario}/vagas/{id}")
    public void deletaVaga(@PathVariable("usuario") String usuario, @PathVariable("id") Long id){

        vagasService.delete(id);
    }
}
