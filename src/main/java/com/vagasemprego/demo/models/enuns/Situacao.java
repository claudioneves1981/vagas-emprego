package com.vagasemprego.demo.models.enuns;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public enum Situacao {

    OFERTA(0L,"OFERTA"),
    DESISTI(1L, "DESISTI"),
    AGUARDANDO(2L,"AGUARDANDO"),
    CONGELADA(3L,"CONGELADA"),
    ANDAMENTO(4L,"ANDAMENTO"),
    ELIMINADO(5L,"ELIMINADO"),
    INSCRITO(6L,"INSCRITO");


    @Id
    @Column(name = "ID_SITUACAO")
    private Long id;

    @Column(name = "SITUACAO")
    private String situacao;
}
