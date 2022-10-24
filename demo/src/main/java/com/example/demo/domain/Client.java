package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull(message = "phone number is null")
    @NotBlank(message = "phone number is empty")
    private String phoneNumber;

    public Client (){

    }
    public Client(String dni, String name, String address, String phoneNumber) {
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
}
