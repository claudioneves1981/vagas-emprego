package com.vagasemprego.demo.security;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {

    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;
    public static String HEADER;

    public void setPrefix(String prefix) {
        PREFIX = prefix;
    }

    public void setKey(String key) {
        KEY = key;
    }

    public void setExpiration(Long expiration) {
        EXPIRATION = expiration;
    }

    public void setHeader(String header) {
        HEADER = header;
    }
}