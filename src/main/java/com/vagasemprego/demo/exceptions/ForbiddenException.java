package com.vagasemprego.demo.exceptions;

public class ForbiddenException extends RuntimeException {
  public ForbiddenException() {
    super("You do not have permission to perform this action. Please contact the administrator if you believe this is an error.");
  }
}
