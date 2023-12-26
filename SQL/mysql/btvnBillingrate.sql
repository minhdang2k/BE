create schema billing_system;

use billing_system;

create table employee (
	employee_id int primary key auto_increment,
	employee_name varchar(200),
    address varchar(500),
    birthday date
    );

create table project (
	project_id int primary key auto_increment,
    project_name varchar(200),
    start_date date
    );

