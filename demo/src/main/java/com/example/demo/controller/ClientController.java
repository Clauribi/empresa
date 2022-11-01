package com.example.demo.controller;

import com.example.demo.domain.ExceptionInvoiceAlreadyExist;
import com.example.demo.domain.ExceptionClientAlreadyExist;
import com.example.demo.domain.ExceptionClientDoesNotExist;
import com.example.demo.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClientController {

    @Autowired
    ClientServices clientServices;


    @PostMapping("/clients")
    public ResponseEntity<String> addClient( @RequestBody ClientInput clientInput) {
        try {
           clientServices.addClient(clientInput);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ExceptionClientAlreadyExist e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }
    }
    @PostMapping("/client/invoice")
    public ResponseEntity<String> addInvoiceToClient( @Valid @RequestBody InvoiceInput invoiceInput){
        try{
            clientServices.addInvoiceToClient(invoiceInput);
        }catch(ExceptionClientDoesNotExist e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(ExceptionInvoiceAlreadyExist e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}