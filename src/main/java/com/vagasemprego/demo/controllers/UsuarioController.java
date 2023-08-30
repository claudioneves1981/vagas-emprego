package com.vagasemprego.demo.controllers;

import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/users")
    public List<Usuario> users(){
        return usuarioService.findAll();
    }

    @GetMapping("/users/{usuario}")
    public Usuario usuario(@PathVariable("usuario") String usuario){
        return usuarioService.findByUsuario(usuario);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody Usuario user){
        usuarioService.createUser(user);
    }
}
