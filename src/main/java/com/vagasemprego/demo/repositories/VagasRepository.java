package com.vagasemprego.demo.repositories;

import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.List;

public interface VagasRepository extends JpaRepository<Vagas, Long> {

    Collection<Vagas> findByUsuario(Usuario usuario);

    List<Vagas> findByUsuarioIdAndSituacao(Long userId, String situacao);
    List<Vagas> findByUsuarioIdAndInteresse(Long userId, String interesse);
    List<Vagas> findByUsuarioIdAndContrato(Long userId, String contrato);
    List<Vagas> findByUsuarioIdAndTipo(Long userId, String tipo);

}
