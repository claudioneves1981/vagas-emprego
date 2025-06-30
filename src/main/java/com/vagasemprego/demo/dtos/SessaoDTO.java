package com.vagasemprego.demo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessaoDTO(

        String refreshToken,
        String token
) {


}
