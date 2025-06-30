package com.vagasemprego.demo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessaoDTO{

        private final String refreshToken;
        private final String token;

    public SessaoDTO(String refreshToken, String token) {
        this.refreshToken = refreshToken;
        this.token = token;
    }

    public String refreshToken() {
         return this.refreshToken;
     }

     public String token(){
         return this.token;
     }

}
