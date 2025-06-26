package com.vagasemprego.demo.utils;

public class ValidationUtil {

    public static void validateIdOrThrowException(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID: " + id);
        }
    }

}
