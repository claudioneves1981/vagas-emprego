package com.vagasemprego.demo.repositories;

import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.models.enuns.Contrato;
import com.vagasemprego.demo.models.enuns.Interesse;
import com.vagasemprego.demo.models.enuns.Situacao;
import com.vagasemprego.demo.models.enuns.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagasRepository extends JpaRepository<Vagas, Long> {


    List<Vagas> findByTipo(Enum<Tipo> tipo);

    List<Vagas> findByContrato(Enum<Contrato> contrato);

    List<Vagas> findByInteresse(Enum<Interesse> interesse);

    List<Vagas> findBySituacao(Enum<Situacao> situacao);

}
