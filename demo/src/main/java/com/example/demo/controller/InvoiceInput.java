package com.example.demo.controller;

import com.example.demo.domain.Invoice;
import com.example.demo.domain.Client;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;

public class InvoiceInput {
    @Id
    private String invoiceId;
    @NotNull(message = "Invoice date not valid")
    private Date date1;
    @Positive(message = "Invoice price not valid")
    private double price;
    @NotNull(message = "Invoices client id not valid")
    @NotBlank(message = "Invoices client id not valid")
    private String clientDni;

    public InvoiceInput() {
    }


    public InvoiceInput(String invoiceId, Date date1, double price, String clientDni) {
        this.invoiceId = invoiceId;
        this.date1 = date1;
        this.price = price;
        this.clientDni = clientDni;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
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
        Invoice b = new Invoice(this.invoiceId, this.date1, this.price, this.clientDni);
        return b;
    }
}


