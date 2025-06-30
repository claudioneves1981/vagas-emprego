package com.vagasemprego.demo.dtos;

import com.vagasemprego.demo.models.Usuario;

public record UserResponseDTO(

        Long id,
        String name,
        Usuario.Role role

) {
}
