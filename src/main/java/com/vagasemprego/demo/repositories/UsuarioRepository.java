package com.vagasemprego.demo.repositories;

import com.vagasemprego.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.usuario = (:usuario)")
    Usuario findByUsuario(@Param("usuario") String usuario);



}
