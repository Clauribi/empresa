package com.example.demo.controller;

import com.example.demo.domain.Client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "phone number is null")
    @NotBlank(message = "phone number is empty")
    private String phoneNumber;

    public ClientInput(String dni, String name, String address, String phoneNumber) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Client clientInputToDomain() {
        Client c = new Client (this.dni,this.name, this.address,this.phoneNumber);
        return c;
    }
}
