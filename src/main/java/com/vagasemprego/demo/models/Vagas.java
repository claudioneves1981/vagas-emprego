package com.vagasemprego.demo.models;

import com.vagasemprego.demo.models.enuns.Contrato;
import com.vagasemprego.demo.models.enuns.Interesse;
import com.vagasemprego.demo.models.enuns.Situacao;
import com.vagasemprego.demo.models.enuns.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vagas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VAGAS")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario;

    @Column(name = "EMPRESA")
    private String empresa;

    @Column(name = "VAGA")
    private String vaga;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="SITUACAO")
    private Situacao situacao;

    @Column(name="ORIGEM")
    private String origem;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="INTERESSE")
    private Interesse interesse;

    @Column(name="SALARIO")
    private Double salario;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="CONTRATO")
    private Contrato contrato;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="TIPO")
    private Tipo tipo;

    @Column(name="BENEFICIOS")
    private String beneficios;

    @Column(name="DATA_INSCRICAO")
    private LocalDate inscricao;

    @Column(name="OBSERVACOES")
    private String observacoes;

}
