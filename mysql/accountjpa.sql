create database accountjdbc;

use accountjdbc;

create table accountjdbc(
id bigint primary key auto_increment,
username varchar(200),
password varchar(200),
firstname varchar(100),
lastname varchar(100),
email varchar(200),
status boolean,
create_date datetime
);