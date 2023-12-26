create database employee;

use employee;

create table employee(
maNV varchar(10) primary key,
ho_tenLot varchar(20),
ten varchar(10),
ngaysinh varchar(20),
email varchar(50),
phone varchar(10),
luong int(10)
);

insert into employee
values 
('A123','DangTieu','Minh','27/01/2000','minh@gmail.com',1234567890,10000),
('B234','Cristiano','Siu','20/02/1999','ronal@gmail.com',0123456789,20000),
('C345','LeoNat','Mexi','15/10/2003','mexi@gmail.com',1234567809,30000),
('D456','NguyenVan','Quoc','6/02/2005','quoc@gmail.com',1234567899,15000);