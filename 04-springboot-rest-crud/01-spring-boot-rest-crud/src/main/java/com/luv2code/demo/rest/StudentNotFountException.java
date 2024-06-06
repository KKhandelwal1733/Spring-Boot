package com.luv2code.demo.rest;

public class StudentNotFountException extends RuntimeException {

    public StudentNotFountException(String message) {
        super(message);
    }

    public StudentNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFountException(Throwable cause) {
        super(cause);
    }
}
