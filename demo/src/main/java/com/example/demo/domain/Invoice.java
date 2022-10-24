package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;

@Entity (name = "Invoices")
public class Invoice {
    @Id
    private String idReference;
    @NotNull (message = "Invoice date is null")
    private Date dateInvoice;
    @Positive ( message = "Invoice is negative")
    private double price;
    @NotNull(message =  "client id is null")
    @NotBlank(message =  "client id is empty")
    private String clientDni;

    public Invoice(){}

    public Invoice(String idReference, Date dateInvoice, double price, String clientDni) {
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
}
