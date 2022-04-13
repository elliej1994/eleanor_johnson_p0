--dev.johnson.eleanor.project0.banking

create table bankaccount(
account_no int generated always as identity,
balance numeric(10,2),
firstname varchar(50),
lastname varchar(50),
cust_mobile_no varchar(30),
username varchar(20) not null,
password varchar(20) not null,
primary key(account_no)
);


create table transactiondetails(
trans_no int generated always as identity,
account_no int,
date_of_transaction varchar(30),
type_of_transaction varchar(15),
transaction_amount bigint,
primary key(trans_no),
constraint fk_bankaccount
	foreign key(account_no)
		references bankaccount(account_no)
		on delete cascade
);

select * from bankaccount;
select * from transactiondetails;

drop table bankaccount;
drop table transactiondetails;
