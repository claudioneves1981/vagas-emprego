package com.vagasemprego.demo.services;

import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.models.enuns.Contrato;
import com.vagasemprego.demo.models.enuns.Interesse;
import com.vagasemprego.demo.models.enuns.Situacao;
import com.vagasemprego.demo.models.enuns.Tipo;
import com.vagasemprego.demo.repositories.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagasService {

    @Autowired
    private VagasRepository vagasRepository;

    public List<Vagas> findByContrato(String contrato) {
            return vagasRepository.findByContrato(Contrato.valueOf(contrato.toUpperCase()));
    }

    public List<Vagas> findByTipo(String tipo) {
        return vagasRepository.findByTipo(Tipo.valueOf(tipo.toUpperCase()));
    }

    public List<Vagas> findBySituacao(String situacao) {
        return vagasRepository.findBySituacao(Situacao.valueOf(situacao.toUpperCase()));
    }

    public List<Vagas> findByInteresse(String interesse){
        return vagasRepository.findByInteresse(Interesse.valueOf(interesse.toUpperCase()));
    }

}
