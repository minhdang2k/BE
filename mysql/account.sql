create database account;

use account;

create table account(
id bigint primary key auto_increment,
username varchar(200),
password varchar(200),
status boolean,
create_date datetime
);

insert into account(username, password, status, create_date) 
values
('minh','123456',true,now())
;

select * from account;