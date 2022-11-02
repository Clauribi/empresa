package com.example.demo.domain;

public class ExceptionClientDoesNotExist extends Exception {
    public ExceptionClientDoesNotExist() {
        super(  "Client doesn´t exists" );
    }
}
