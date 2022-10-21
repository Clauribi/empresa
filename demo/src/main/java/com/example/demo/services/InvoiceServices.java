package com.example.demo.services;

import com.example.demo.domain.Invoice;
import com.example.demo.domain.ExceptionClientDoesNotExist;
import com.example.demo.domain.ExceptionClientDoesNotHaveInvoices;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServices {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ClientRepository clientRepository;

   public List<Invoice> listInvoicesForOneClient(String dni) throws ExceptionClientDoesNotHaveInvoices, ExceptionClientDoesNotExist {

       if(!clientRepository.existsById(dni))throw new ExceptionClientDoesNotExist();
       List<Invoice> invoices = invoiceRepository.findAllByClientDni();
       if (invoices.isEmpty()) throw new ExceptionClientDoesNotHaveInvoices(dni);

       return invoices;
   }
}
