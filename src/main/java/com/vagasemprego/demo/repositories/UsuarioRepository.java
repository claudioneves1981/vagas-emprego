package com.vagasemprego.demo.repositories;

import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.enuns.Contrato;
import com.vagasemprego.demo.models.enuns.Interesse;
import com.vagasemprego.demo.models.enuns.Situacao;
import com.vagasemprego.demo.models.enuns.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //@Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.usuario = (:usuario)")
    Optional<Usuario> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);
}
