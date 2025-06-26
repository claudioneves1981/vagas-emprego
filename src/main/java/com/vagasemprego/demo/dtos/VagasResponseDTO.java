package com.vagasemprego.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vagasemprego.demo.models.enuns.Contrato;
import com.vagasemprego.demo.models.enuns.Interesse;
import com.vagasemprego.demo.models.enuns.Situacao;
import com.vagasemprego.demo.models.enuns.Tipo;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record VagasResponseDTO(

        Long id,
        String empresa,
        String vaga,
        Situacao situacao,
        String origem,
        Interesse interesse,
        Double salario,
        Contrato contrato,
        Tipo tipo,
        String beneficios,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime inscricao,
        String observacoes,

        UserResponseDTO user

) {
}
