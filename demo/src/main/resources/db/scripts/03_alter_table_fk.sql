ALTER TABLE invoices ADD CONSTRAINT fk_client_dni FOREIGN KEY (client_dni) REFERENCES clients (dni);
