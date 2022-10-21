create table invoices(
    id_reference varchar(50) primary key,
    date_invoice date not null,
    price double not null,
    client_dni varchar(10) not null
 );




