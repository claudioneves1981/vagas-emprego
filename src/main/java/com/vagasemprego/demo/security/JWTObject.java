package com.vagasemprego.demo.security;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class JWTObject {
    private String subject;
    private Long issuedAt;
    private Long expiration;
    private Long refreshExpiration;
    //private String secret;
    //private String refreshSecret;
    private List<String> roles;

}
