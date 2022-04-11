--dev.johnson.eleanor.project0.banking


--Account will store the savings, and default checking balance, users will be able to see their balance after 


--create

create table bankaccountinfo(
account_no int generated always as identity,
balance float,
firstname varchar(50),
lastname varchar(50),
cust_mobile_no varchar(30),
username varchar(20) not null,
password varchar(20) not null,
primary key(account_no)
);

insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (26.81, 'Mitch Jasiak', '397-761-0334', 'mjasiak0', 'SkNJsH79');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (96.61, 'Honey Bohler', '847-247-5447', 'hbohler1', 'lHAnio93cZnm');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (27.13, 'Henrietta Sincock', '422-919-2249', 'hsincock2', '3WqpPeVM');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (61.92, 'Ephrayim Marchington', '231-216-0749', 'emarchington3', '0LMzeVlH');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (69.37, 'Wes Le Quesne', '785-853-3509', 'wle4', 'TVkSGCYvkY');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (75.75, 'Gena Dolder', '450-638-2204', 'gdolder5', '9ZZt8c');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (79.12, 'Avery Gronav', '573-841-1322', 'agronav6', 'gmJ8aJkE87');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (77.48, 'Yuri Thamelt', '955-133-7987', 'ythamelt7', '8jFpZG6wZpZ');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (74.35, 'Alysia Enderwick', '730-191-0211', 'aenderwick8', 'MpNQy1asfF');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (66.35, 'Matilde Sandes', '976-631-8141', 'msandes9', 'b9xT6U8UcTA');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (62.81, 'Lemuel Eisak', '807-790-4496', 'leisaka', 'TVCvm4uAdWr');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (18.39, 'Nessy Kirimaa', '963-541-8447', 'nkirimaab', 'TcmbDW5Ctb6X');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (86.16, 'Chiarra Ottosen', '721-746-2120', 'cottosenc', 'QfeDwy');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (89.35, 'Obed Batiste', '207-738-6218', 'obatisted', 'fegq9ro');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (36.72, 'Trenton Bricksey', '174-500-8927', 'tbrickseye', 'FyLfsXMloF');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (9.15, 'Gabie Cansdall', '399-930-4658', 'gcansdallf', 'dbL6uw');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (65.72, 'Vonny Louthe', '713-750-8989', 'vloutheg', 'sYg2giRf');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (32.17, 'Damara While', '746-708-2721', 'dwhileh', 'IlABY6');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (1.59, 'Sibley Dumingos', '687-438-7010', 'sdumingosi', 'OkXZextSvK6');
insert into bankaccountinfo (balance, cust_name, cust_mobile_no, username, password) values (66.28, 'Timothy Holberry', '419-684-3431', 'tholberryj', 'hlcjqxUPmySj');





--not using for now testing testing 
create table customerinfo(
customer_id int generated always as identity,
account_no int,
cust_name varchar(200),
customer_mobile_no varchar(15) unique,
username varchar(20) not null,
password varchar(20) not null,
primary key(customer_id),
constraint fk_bankaccountinfo
	foreign key(account_no)
		references bankaccountinfo(account_no)
		on delete cascade
);

--ignore for now 
create table transactiondetails(
trans_no int generated always as identity,
account_id int,
type_of_transaction varchar(15),
transaction_amount int,
primary key(trans_no),
constraint fk_bankaccountinfo
	foreign key(account_no)
		references account(account_no)
		on delete cascade
);




--read

select * from bankaccountinfo;


select * from account left outer join users on (account.account_id=users.user_account_num)
group by account_id;

--update 
insert into <tablename> (column1, colum2,..)
values(value1, value2)









create or replace procedure makedeposit(
custusername varchar,
val int
)
language plpgsql as 
$$
begin 
	update bankaccountinfo
	set balance = balance + val
	where username = custusername;
end;
$$

call makedeposit('hsincock2', 500);



create or replace procedure withdraw_amount(custusername in varchar, val in int)
is 
begin 
	update bankaccountinfo
	set balance = balance - val
	where username = custusername;
end;

commit;



--delete
drop table bankaccountinfo;
drop function makedeposit;
