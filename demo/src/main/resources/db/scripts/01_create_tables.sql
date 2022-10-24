create table clients(
	dni varchar(10) primary key,
	name varchar(100) not null,
	address varchar(200) not null,
	phone_number int not null
);
create table invoices(
    id_reference varchar(50) primary key,
    date_invoice date not null,
    price double not null,
    client_dni varchar(10) not null
 );


