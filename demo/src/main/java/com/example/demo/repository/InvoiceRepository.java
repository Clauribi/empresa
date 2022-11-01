package com.example.demo.repository;
import com.example.demo.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,String> {


    List<Invoice> findAllByClientDni(String clientDni);
}
