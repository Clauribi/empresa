package com.example.demo.controller;

import com.example.demo.domain.Client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ClientInput {
    @NotNull(message = "dni is null")
    @NotBlank(message = "dni is empty")
    private String dni;
    @NotNull(message = "name is null")
    @NotBlank( message = "name is empty")
    private String name;
    @NotNull (message = "address is null")
    @NotBlank ( message = "address is empty")
    private String address;
    @Positive(message = "phone number is negative")
    private int phoneNumber;


    public ClientInput(String dni, String name, String address, int phoneNumber) {
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

    public Client clientInputToDomain() {
        Client c = new Client (this.dni,this.name, this.address,this.phoneNumber);
        return c;
    }
}
