package com.example.demo.domain;

public class ExceptionClientDoesNotHaveInvoices extends Exception {
    public ExceptionClientDoesNotHaveInvoices(String dni) {
        super(  "Client " + dni +" doesn´t have invoices" );
    }
}


