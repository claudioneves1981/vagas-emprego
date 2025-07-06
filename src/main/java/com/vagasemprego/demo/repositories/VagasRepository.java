package com.vagasemprego.demo.repositories;

import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import com.vagasemprego.demo.models.enuns.Contrato;
import com.vagasemprego.demo.models.enuns.Interesse;
import com.vagasemprego.demo.models.enuns.Situacao;
import com.vagasemprego.demo.models.enuns.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.List;

public interface VagasRepository extends JpaRepository<Vagas, Long> {

    Collection<Vagas> findByUsuario(Usuario usuario);

    List<Vagas> findByUsuarioIdAndSituacao(Long userId, Situacao situacao);
    List<Vagas> findByUsuarioIdAndInteresse(Long userId, Interesse interesse);
    List<Vagas> findByUsuarioIdAndContrato(Long userId, Contrato contrato);
    List<Vagas> findByUsuarioIdAndTipo(Long userId, Tipo tipo);

}
