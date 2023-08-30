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
public enum Interesse {

    BAIXISSIMO(0L,"BAIXISSIMO"),
    BAIXO(1L,"BAIXO"),
    MEDIO(2L,"MÉDIO"),
    ALTO(3L,"ALTO"),
    ALTISSIMO(4L,"ALTISSIMO");

    @Id
    @Column(name = "ID_INTERESSE")
    private Long id;

    @Column(name = "INTERESSE")
    private String interesse;

}
