package com.example.demo.controller;

import com.example.demo.domain.Invoice;
import com.example.demo.domain.Client;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;

public class InvoiceInput {

    private String idReference;
    @NotNull(message = "Invoice date not valid")
    private Date dateInvoice;
    @Positive(message = "Invoice price not valid")
    private double price;
    @NotNull(message = "Invoices client id not valid")
    @NotBlank(message = "Invoices client id not valid")
    private String clientDni;

    public InvoiceInput() {
    }


    public InvoiceInput(String idReference, Date dateInvoice, double price, String clientDni) {
        this.idReference = idReference;
        this.dateInvoice = dateInvoice;
        this.price = price;
        this.clientDni = clientDni;
    }

    public String getIdReference() {
        return idReference;
    }

    public void setIdReference(String idReference) {
        this.idReference = idReference;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public Invoice invoiceInputToDomain() {
        Invoice b = new Invoice(this.idReference, this.dateInvoice, this.price, this.clientDni);
        return b;
    }
}


