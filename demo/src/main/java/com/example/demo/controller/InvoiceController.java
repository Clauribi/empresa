package com.example.demo.controller;

import com.example.demo.domain.Invoice;
import com.example.demo.domain.ExceptionClientDoesNotExist;
import com.example.demo.domain.ExceptionClientDoesNotHaveInvoices;
import com.example.demo.services.InvoiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceServices invoiceServices;

    @GetMapping("/invoices/{clientDni}")
    public ResponseEntity<List<Invoice>> listInvoicesForOneClient(@PathVariable String clientDni){
        try {
            List<Invoice> invoice = invoiceServices.listInvoicesForOneClient(clientDni);
            return ResponseEntity.ok(invoice);
        } catch (ExceptionClientDoesNotHaveInvoices e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (ExceptionClientDoesNotExist e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}


