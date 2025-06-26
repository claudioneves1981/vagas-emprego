package com.vagasemprego.demo.repositories;

import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.List;

public interface VagasRepository extends JpaRepository<Vagas, Long> {

    Collection<Vagas> findByUsuario(Usuario usuario);

    List<Vagas> findByUserIdAndSituacao(Long id, String situacao);
    List<Vagas> findByUserIdAndInteresse(Long id, String interesse);
    List<Vagas> findByUserIdAndContrato(Long id, String contrato);
    List<Vagas> findByUserIdAndTipo(Long id, String  tipo);

}
