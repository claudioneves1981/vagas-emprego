package com.vagasemprego.demo.mappers;

import com.vagasemprego.demo.dtos.VagasResponseDTO;
import com.vagasemprego.demo.models.Vagas;

public class VagasMapper {

    public static VagasResponseDTO toDto(Vagas vagas) {
        return new VagasResponseDTO(
                vagas.getId(),
                vagas.getEmpresa(),
                vagas.getVaga(),
                vagas.getSituacao(),
                vagas.getOrigem(),
                vagas.getInteresse(),
                vagas.getSalario(),
                vagas.getContrato(),
                vagas.getTipo(),
                vagas.getBeneficios(),
                vagas.getInscricao(),
                vagas.getObservacoes(),
                UserMapper.toDto(vagas.getUsuario())
        );
    }
}
