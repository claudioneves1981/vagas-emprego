package com.vagasemprego.demo.exceptions;

public class EntityUserNotFoundException extends RuntimeException {

    public EntityUserNotFoundException(String usuario) {
        super("User not found: " + usuario);
    }

    public EntityUserNotFoundException(Long id) {
        super("User not found with id: " + id);
    }

}
