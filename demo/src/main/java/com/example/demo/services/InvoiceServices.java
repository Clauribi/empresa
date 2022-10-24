package com.example.demo.services;

import com.example.demo.domain.Invoice;
import com.example.demo.domain.ExceptionClientDoesNotExist;
import com.example.demo.domain.ExceptionClientDoesNotHaveInvoices;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServices {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ClientRepository clientRepository;

   public List<Invoice> listInvoicesForOneClient(String dni) throws ExceptionClientDoesNotHaveInvoices, ExceptionClientDoesNotExist {

       if(!clientRepository.existsById(dni))throw new ExceptionClientDoesNotExist();
       List<Invoice> invoices = invoiceRepository.findAll();
       List<Invoice> invoicesById =new ArrayList<>();
       for (Invoice invoice: invoices){
           if(dni.equals(invoice.getClientDni())){
               invoicesById.add(invoice);
           }
       }
       if (invoicesById.isEmpty()) throw new ExceptionClientDoesNotHaveInvoices(dni);
       return invoicesById;
   }
}
