package com.vagasemprego.demo.exceptions;

public class EntityVagasNotFoundException extends RuntimeException {
  public EntityVagasNotFoundException(Long id) {
    super("Vaga not found with id: " + id);
  }
}
