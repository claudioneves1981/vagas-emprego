package com.vagasemprego.demo.dtos;

import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.models.Vagas;

import java.util.List;

public record UserResponseDTO(

        Long id,
        String name,
        Usuario.Role role

) {
}
