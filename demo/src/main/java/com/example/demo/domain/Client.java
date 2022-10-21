package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity ( name = "clients")
public class Client {
    @Id
    private String dni;
    @NotNull (message = "name is null")
    @NotBlank ( message = "name is empty")
    private String name;
    @NotNull (message = "address is null")
    @NotBlank ( message = "address is empty")
    private String address;
    @Positive
    private int phoneNumber;

    public Client (){}
    public Client(String dni, String name, String address, int phoneNumber) {
        this.dni = dni;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
