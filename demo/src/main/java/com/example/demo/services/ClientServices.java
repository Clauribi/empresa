package com.example.demo.services;

import com.example.demo.controller.InvoiceInput;
import com.example.demo.controller.ClientInput;
import com.example.demo.domain.Invoice;
import com.example.demo.domain.Client;
import com.example.demo.domain.ExceptionInvoiceAlreadyExist;
import com.example.demo.domain.ExceptionClientAlreadyExist;
import com.example.demo.domain.ExceptionClientDoesNotExist;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServices {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ClientRepository clientRepository;

    public void addClient(ClientInput clientInput) throws ExceptionClientAlreadyExist {
        if (clientRepository.existsById(clientInput.getDni())) throw new ExceptionClientAlreadyExist();
        Client c = clientInput.clientInputToDomain();
        clientRepository.save(c);
    }

    public void addInvoiceToClient( InvoiceInput invoiceInput) throws ExceptionClientDoesNotExist, ExceptionInvoiceAlreadyExist {
        if(!clientRepository.existsById(invoiceInput.getClientDni())) throw new ExceptionClientDoesNotExist();
        Invoice b = invoiceInput.invoiceInputToDomain();
        if(invoiceRepository.existsById(b.getId_reference())) throw new ExceptionInvoiceAlreadyExist();
        invoiceRepository.save(b);
    }
}
