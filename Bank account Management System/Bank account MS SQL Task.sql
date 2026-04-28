create database bams;
use bams;
create table customer(
customer_id int Primary key,
name varchar(20) not null,
city varchar(50));

create table accounts(
account_id int Primary key,
customer_id int unique,
balance decimal(10,2) check(balance>=0),
account_type varchar(30), 
foreign key (customer_id) references customer(customer_id)
);

insert into customer(customer_id,name,city)
values(1,'Akash','Indore'),
(2,'Shiva','Hyderabad'),
(3,'Praveen','Hyderabad');

insert into accounts(account_id,customer_id,balance,account_type
) values(1,1,10000,'current current'),
(2,2,12000,'current current'),
(3,3,30000,'saving current');

update accounts set balance=balance+2000 where customer_id=1;
update accounts set balance=balance-1000 where customer_id=2 
and balance>=1000;
delete from accounts where balance<2000;

select * from customer where city='hyderabad';
select * from accounts where balance>5000;
select * from accounts order by balance desc;
