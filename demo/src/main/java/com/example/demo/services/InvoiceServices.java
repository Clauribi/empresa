package com.example.demo.services;

import com.example.demo.domain.Invoice;
import com.example.demo.domain.ExceptionClientDoesNotExist;
import com.example.demo.domain.ExceptionClientDoesNotHaveInvoices;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceServices {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ClientRepository clientRepository;

  public List<Invoice> listInvoicesForOneClient(String clientDni) throws ExceptionClientDoesNotExist, ExceptionClientDoesNotHaveInvoices {
      if(!clientRepository.existsById(clientDni))throw new ExceptionClientDoesNotExist();
      List<Invoice> invoicesOneClient = invoiceRepository.findAllByClientDni(clientDni);
      if (invoicesOneClient.isEmpty()) throw new ExceptionClientDoesNotHaveInvoices(clientDni);
      return invoicesOneClient;
  }


    public List<Invoice> listInvoicesForOneClientAndDates(String clientDni, Date dateA, Date dateB) throws ExceptionClientDoesNotExist, ExceptionClientDoesNotHaveInvoices {
        if(!clientRepository.existsById(clientDni))throw new ExceptionClientDoesNotExist();
        List<Invoice> invoicesByClientAndDate = invoiceRepository.findByClientDniAndDateInvoiceBetween(clientDni, dateA, dateB);
        if (invoicesByClientAndDate.isEmpty()) throw new ExceptionClientDoesNotHaveInvoices(clientDni);
        return invoicesByClientAndDate;
    }
}
