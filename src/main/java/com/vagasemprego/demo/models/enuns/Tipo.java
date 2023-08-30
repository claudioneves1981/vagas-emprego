package com.vagasemprego.demo.models.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public enum Tipo {

    REMOTO(0L,"REMOTO"),
    HIBRIDO(1L,"HIBRIDO"),
    PRESENCIAL(2L,"PRESENCIAL");

    @Id
    @Column(name = "ID_TIPO")
    private Long id;

    @Column(name = "TIPO")
    private String tipo;

}
