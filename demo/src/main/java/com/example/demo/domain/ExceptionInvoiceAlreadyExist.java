package com.example.demo.domain;

public class ExceptionInvoiceAlreadyExist extends Exception {
    public ExceptionInvoiceAlreadyExist() {
        super(  "Invoice already exists" );
    }
}
