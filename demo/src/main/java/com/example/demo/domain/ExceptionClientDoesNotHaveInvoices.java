package com.example.demo.domain;

public class ExceptionClientDoesNotHaveInvoices extends Exception {
    public ExceptionClientDoesNotHaveInvoices(String dni) {
        super(  "Client " + dni +" does not have invoices" );
    }
}


