package com.example.demo.domain;

public class ExceptionClientAlreadyExist extends Exception {
    public ExceptionClientAlreadyExist() {
        super(  "Client already exists" );
    }
}
