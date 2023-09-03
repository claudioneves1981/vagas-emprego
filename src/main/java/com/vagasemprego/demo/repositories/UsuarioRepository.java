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


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.usuario = (:usuario)")
    Usuario findByUsuario(@Param("usuario") String usuario);

    @Query("SELECT u FROM Usuario u JOIN Vagas v ON u.usuario = (:usuario) WHERE v.situacao = (:situacao)")
    Usuario findBySituacao(@Param("usuario") String usuario, @Param("situacao") Enum<Situacao> situacao);

    @Query("SELECT u FROM Usuario u JOIN Vagas v ON u.usuario = (:usuario) WHERE v.tipo = (:tipo)")
    Usuario findByTipo(@Param("usuario") String usuario, @Param("tipo") Enum<Tipo> tipo);

    @Query("SELECT u FROM Usuario u JOIN Vagas v ON u.usuario = (:usuario) WHERE v.contrato = (:contrato)")
    Usuario findByContrato(@Param("usuario") String usuario, @Param("contrato") Enum<Contrato> contrato);

    @Query("SELECT u FROM Usuario u JOIN Vagas v ON u.usuario = (:usuario) WHERE v.interesse = (:interesse)")
    Usuario findByInteresse(@Param("usuario") String usuario, @Param("interesse") Enum<Interesse> interesse);

}
