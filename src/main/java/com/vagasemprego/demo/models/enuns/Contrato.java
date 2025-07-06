package com.vagasemprego.demo.models.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public enum Contrato {

    PJ(0L,"PJ"),
    CLT(1L,"CLT"),
    FREELANCE(2L,"FREELANCE"),
    TEMPORARIO(3L,"TEMPORÁRIO"),
    ESTAGIO(4L,"ESTÁGIO"),
    TRAINEE(5L,"TRAINEE"),
    OUTROS(6L,"OUTROS");


    @Id
    @Column(name = "ID_CONTRATO")
    private Long id;

    @Column(name = "CONTRATO")
    private String situacao;
}
