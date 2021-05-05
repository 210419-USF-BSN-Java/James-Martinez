create schema radioactive_reptiles;

create table employee(
name varchar(25),
employeeid int,
email varchar(25),
password varchar(20),
manager varchar(1)
)

create sequence rr_seq_1
increment 5
minvalue 100
maxvalue 2147483648 start 100
cache 1;

alter table employee alter column employeeid
set default nextval('rr_seq_1');

insert into employee(name,email,password,manager)values('Manager Mike','manager@gmail.com','Manager1','Y');
insert into employee(name,email,password,manager)values('Employee Edward','employee@gmail.com','Employee1','N');

create table customer(
customerid int,
name varchar(25),
email varchar(30),
password varchar(20),
location varchar(35)
);

insert into customer(name, email, password, location)values('James Martinez', 'jmike@gmail.com', 'Password1', 'New York City');
insert into customer(name, email, password, location)values('Daniel Gomez', 'dangomez@gmail.com', 'Password2', 'Alaska');
insert into customer(name, email, password, location)values('Mercedez LaCroix', 'mlacroix@gmail.com', 'Password3', 'Nevada');
insert into customer(name, email, password, location)values('King Tchalla', 'wakanda@gmail.com', 'Password4', 'Kenya');
insert into customer(name, email, password, location)values('Lilo Pelekai', 'lilostitch@gmail.com', 'Password5', 'Hawaii');

create sequence rr_seq_2
increment 10
minvalue 1000
maxvalue 2147483648 start 1000
cache 1;

alter table customer alter column customerid
set default nextval('rr_seq_2');

create table payments(
paymentid int primary key,
customerid int,
amount double precision,
datetime timestamp 
)

ALTER TABLE radioactive_reptiles.payments ALTER COLUMN datetime SET DEFAULT CURRENT_TIMESTAMP;

create table purchases(
purchaseid int,
customerid int,
inventoryid varchar(4),
mutationid varchar(4),
buyprice double precision,
balance double precision,
purchasedate timestamp
);

ALTER TABLE radioactive_reptiles.sales ALTER COLUMN purchasedate SET DEFAULT CURRENT_TIMESTAMP;

create table product(
productid varchar(4),
name varchar(30),
size varchar(1),
description varchar(200),
price double precision,
stock int
)

insert into product(productid,name,size,description,price,stock)values('F001','Reptilian Feed','S', 'Dragon Feed small size, consists mostly of small to medium size rodents
guaranteed to ship alive and last for up to two weeks', 95, 10);

insert into product(productid,name,size,description,price,stock)values('F004','Aquatic Feed','S', 'Aquatic Feed small size, consists mostly of krill and small fish
guaranteed to ship alive and last for up to two weeks', 85, 10);

select description from product where productid = 'F001';

create table mutation(
mutationid varchar(4) primary key,
name varchar(30),
size varchar(1),
heightweight varchar(25),
description varchar(200),
bid double precision,
stock int
)

insert into mutation(mutationid,name,size,heightweight,description,bid,stock)values('MR01','Great Dragon','L','Height:76 inches Weight:422 pounds ' ,'Timid, prefers temperate locations, this is the largest reptilian mutation available keep away from children', 200000, 1);

ALTER TABLE radioactive_reptiles.customer ADD CONSTRAINT customer_pk PRIMARY KEY (customerid);
ALTER TABLE radioactive_reptiles.employee ADD CONSTRAINT employee_pk PRIMARY KEY (employeeid);
ALTER TABLE radioactive_reptiles.inventory ADD CONSTRAINT inventory_pk PRIMARY KEY (inventoryid);
ALTER TABLE radioactive_reptiles.sales ADD CONSTRAINT sales_pk PRIMARY KEY (salesid);

ALTER TABLE radioactive_reptiles.sales ADD CONSTRAINT sales_fk FOREIGN KEY (customerid) REFERENCES radioactive_reptiles.customer(customerid);
ALTER TABLE radioactive_reptiles.sales ADD CONSTRAINT sales_fk2 FOREIGN KEY (productid) REFERENCES radioactive_reptiles.product(productid);
ALTER TABLE radioactive_reptiles.sales ADD CONSTRAINT sales_fk3 FOREIGN KEY (mutationid) REFERENCES radioactive_reptiles.mutation(mutationid);
ALTER TABLE radioactive_reptiles.payments ADD CONSTRAINT payments_fk FOREIGN KEY (customerid) REFERENCES radioactive_reptiles.customer(customerid);