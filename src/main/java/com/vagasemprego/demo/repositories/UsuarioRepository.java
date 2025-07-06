package com.vagasemprego.demo.repositories;

import com.vagasemprego.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //@Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.usuario = (:usuario)")
    Optional<Usuario> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);
}
