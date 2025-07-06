package com.vagasemprego.demo.services;

import com.vagasemprego.demo.exceptions.ForbiddenException;
import com.vagasemprego.demo.exceptions.InvalidJwtException;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.security.JWTCreator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SessaoService {

    private final JWTCreator jwtTokenProvider;

    public SessaoService(JWTCreator jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional(readOnly = true)
    void validateUserOwnership(Usuario userById) {
        UserDetails authentication;

        try {
            authentication = jwtTokenProvider.getAuthentication();
        } catch (InvalidJwtException e) {
            throw new ForbiddenException();
        }

        if (authentication == null) {
            throw new ForbiddenException();
        }

        Optional<? extends GrantedAuthority> authorityOpt = authentication.getAuthorities().stream().findFirst();

        if (authorityOpt.isEmpty()) {
            throw new ForbiddenException();
        }

        GrantedAuthority authority = authorityOpt.get();
        String username = authentication.getUsername();
        boolean roleAdmin = authority.getAuthority().equals("ROLE_ADMIN");

        if (!roleAdmin) {
            if (!userById.getUsuario().equals(username)) {
                throw new ForbiddenException();
            }
        }
    }



}
