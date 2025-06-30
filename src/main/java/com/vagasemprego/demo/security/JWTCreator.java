package com.vagasemprego.demo.security;
import com.vagasemprego.demo.dtos.SessaoDTO;
import com.vagasemprego.demo.exceptions.InvalidJwtException;
import com.vagasemprego.demo.models.Usuario;
import com.vagasemprego.demo.repositories.UsuarioRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Clock;
import java.util.*;

@Component
public class JWTCreator {

    public static final String ROLES_AUTHORITIES = "role";
    private final Clock clock;
    private JWTObject jwtObject;
    private Key secretKey;
    private Key refreshSecretKey;
    private final UsuarioRepository userRepository;
    private final SessaoDTO sessaoDTO;

    @Autowired
    public JWTCreator(SessaoDTO sessaoDTO, UsuarioRepository userRepository) {
        this(sessaoDTO, userRepository, Clock.systemUTC());
    }

    public JWTCreator(SessaoDTO sessaoDTO, UsuarioRepository userRepository, Clock clock) {
        this.sessaoDTO = sessaoDTO;
        this.userRepository = userRepository;
        this.clock = clock;
    }

    @PostConstruct
    protected void init() {
        try {
            byte[] decodedKeyBytes = Base64.getDecoder().decode(sessaoDTO.token());
            this.secretKey = Keys.hmacShaKeyFor(decodedKeyBytes);
            byte[] decodedRefreshKeyBytes = Base64.getDecoder().decode(sessaoDTO.refreshToken());
            this.refreshSecretKey = Keys.hmacShaKeyFor(decodedRefreshKeyBytes);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Failed to decode JWT secret", e);
        }
    }

    public String generateToken(Authentication authentication) {

        String name = authentication.getName();
        Date now = Date.from(clock.instant());
        Date expiry = Date.from(clock.instant().plusMillis(jwtObject.getExpiration()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(name)
                .claim(ROLES_AUTHORITIES, userDetails.getAuthorities().stream()
                        .map(auth -> auth.getAuthority().replace("ROLE_", "")) // remove prefixo
                        .findFirst()
                        .orElse("USER"))
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken(Authentication authentication) {
        String name = authentication.getName();
        Date now = Date.from(clock.instant());
        Date expiry = Date.from(clock.instant().plusMillis(jwtObject.getRefreshExpiration()));

        return Jwts.builder()
                .setSubject(name)
                .setId(UUID.randomUUID().toString())
                .claim("type", "refresh")
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(refreshSecretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public Usuario getCurrentUser() {
        UserDetails userDetails = getAuthentication();
        if (userDetails != null) {
            String username = userDetails.getUsername();
            return userRepository.findByUsuario(username)
                    .orElseThrow(() -> new InvalidJwtException("User not found with email: " + username));
        }
        throw new InvalidJwtException("No authenticated user found");
    }

    public UserDetails getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        boolean isRoleAnonymous = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ANONYMOUS"));

        if (!isRoleAnonymous) {
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }

    public void validateToken(String token) {

        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
        } catch (Exception e) {
            throw new InvalidJwtException("JWT token is invalid", e);
        }
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


}