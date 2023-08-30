package com.vagasemprego.demo.controllers;

import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.services.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VagasController {

    @Autowired
    private VagasService vagasService;

    @GetMapping("/users/{usuario}/vagas/{contrato}/")
    public List<Vagas> contrato(@PathVariable("usuario") String usuario, @PathVariable("contrato") String contrato) throws Exception {
        return vagasService.findByContrato(contrato);
    }

    @GetMapping("/users/{usuario}/vagas/{interesse}/")
    public List<Vagas> interesse(@PathVariable("usuario") String usuario, @PathVariable("interesse") String interesse) throws Exception {
        return vagasService.findByInteresse(interesse);
    }

    @GetMapping("/users/{usuario}/vagas/{tipo}/")
    public List<Vagas> tipo(@PathVariable("usuario") String usuario, @PathVariable("tipo") String tipo) throws Exception {
        return vagasService.findByTipo(tipo);
    }

    @GetMapping("/users/{usuario}/vagas/{situacao}/")
    public List<Vagas> situacao(@PathVariable("usuario") String usuario, @PathVariable("contrato") String situacao) throws Exception {
        return vagasService.findBySituacao(situacao);
    }
}
