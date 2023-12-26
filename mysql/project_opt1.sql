create schema ABC;

use ABC;



create table project (
	projectid int primary key auto_increment,
	pname varchar(200),
    pstartname varchar(200),
    pdescription varchar(200),
    pdetail varchar(200),
    pcompleteon date
    );

create table employee (
	employeeid int primary key auto_increment,
	elastname varchar(50),
    efirstname varchar(50),
    ehidedate date,
    estatus varchar(200),
    supervisor int(50),
    SSnumber int(50)
    );
    
create table project_modules (
	moduleid int primary key auto_increment,
    projectid int,
    employeeid int,
	pmdate date,
    pmcompleteon date,
    pmdescription varchar(200),
    constraint foreign key pm_prj_fk (projectid) references project(projectid),
	constraint foreign key pm_emp_fk (employeeid) references employee (employeeid)
    );
    
create table workdone (
	workdoneid int primary key auto_increment,
    moduleid int,
    employeeid int,
	wddate date,
    wddescription varchar(200),
    wdstatus varchar(200),
    constraint foreign key wd_pm_fk(moduleid) references project_modules(moduleid),
    constraint foreign key wd_emp_fk(employeeid) references employee(employeeid)
    );



    
    