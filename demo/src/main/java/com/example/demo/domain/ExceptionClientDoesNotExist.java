package com.example.demo.domain;

public class ExceptionClientDoesNotExist extends Exception {
    public ExceptionClientDoesNotExist() {
        super(  "Client does not exists" );
    }
}
