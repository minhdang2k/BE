create schema HR;

use HR;

create table employee (
	constraint primary key employee (employee_id),
    constraint foreign key employee_emp_fk (job_id) references job (job_id),
	constraint foreign key employee_emp_fk (department_id) references department (department_id),
	email varchar(200),
    salary float,
    manager varchar(200),
    commissions float
    );

create table job (
	constraint primary key job (job_id),
    constraint foreign key job_emp_fk (job_title) references job_history (job_title),
    minium_salary float,
    maxium_salry float
    );

create table job_history (
	constraint primary key job (job_history_id),
    constraint foreign key job_history_emp_fk (employee_id) references employee (employee_id),
	duration date
    );

create table department (
	constraint primary key department (department_id),
	constraint foreign key department_emp_fk (location_id) references location (location_id),
    name varchar(200)
    );
    
create table location (
	constraint primary key department (location_id),
	constraint foreign key location_emp_fk (country_code) references country (country_code),
    postal_code int,
    street_name varchar(500),
    city varchar(200),
    state_province varchar(500)
    );

create table country (
	constraint primary key country (country_code),
    country_name varchar(200),
    currency_symbol varchar(200),
    currency_name varchar(200)
    );
    




    
    