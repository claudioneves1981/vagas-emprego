package com.vagasemprego.demo.exceptions;

public class EntityUserAlreadyExistsException extends RuntimeException {
    public EntityUserAlreadyExistsException(String username) {
        super("User already exists: " + username);
    }
}