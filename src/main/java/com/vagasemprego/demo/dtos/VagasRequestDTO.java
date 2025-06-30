package com.vagasemprego.demo.dtos;

import com.vagasemprego.demo.models.enuns.Contrato;
import com.vagasemprego.demo.models.enuns.Interesse;
import com.vagasemprego.demo.models.enuns.Situacao;
import com.vagasemprego.demo.models.enuns.Tipo;

import java.time.LocalDateTime;

public record VagasRequestDTO(

        String empresa,
        String vaga,
        Situacao situacao,
        String origem,
        Interesse interesse,
        Double salario,
        Contrato contrato,
        Tipo tipo,
        String beneficios,
        LocalDateTime inscricao,
        String observacoes

) {
}
