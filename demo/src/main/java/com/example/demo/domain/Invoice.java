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
    private String id_reference;
    @NotNull (message = "Invoice date not valid")
    private Date date_invoice;
    @Positive ( message = "Invoice price not valid")
    private double price;
    @NotNull(message =  "Invoices client id not valid")
    @NotBlank(message =  "Invoices client id not valid")
    private String client_dni;

    public Invoice(){}

    public Invoice(String id_reference, Date date_invoice, double price, String client_dni) {
        this.id_reference = id_reference;
        this.date_invoice = date_invoice;
        this.price = price;
        this.client_dni = client_dni;
    }

    public String getId_reference() {
        return id_reference;
    }

    public void setId_reference(String id_reference) {
        this.id_reference = id_reference;
    }

    public Date getDate_invoice() {
        return date_invoice;
    }

    public void setDate_invoice(Date date_invoice) {
        this.date_invoice = date_invoice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClient_dni() {
        return client_dni;
    }

    public void setClient_dni(String client_dni) {
        this.client_dni = client_dni;
    }
}
