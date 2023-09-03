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

    public void delete(Long id){
        vagasRepository.deleteById(id);
    }

}
