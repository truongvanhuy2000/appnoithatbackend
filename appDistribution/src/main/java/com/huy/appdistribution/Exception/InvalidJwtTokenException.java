package com.huy.appdistribution.Exception;

public class InvalidJwtTokenException extends RuntimeException  {
    public InvalidJwtTokenException(String message) {
        super(message);
    }
}
