package com.vagasemprego.demo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SessaoDTO(

        String refreshToken,
        String token
) {


}
