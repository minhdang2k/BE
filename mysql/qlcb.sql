create schema qlcb;

use qlcb;

create table chuyen_bay (
	ma_cb int primary key auto_increment,
	ga_di varchar(500),
    ga_den varchar(500),
    do_dai float,
    gio_di time,
    gio_den time,
    chi_phi float
);

create table may_bay (
	ma_mb int primary key auto_increment,
	loai varchar(200),
    tam_bay float
);

create table nhan_vien (
	ma_nv int primary key auto_increment,
	ten varchar(200),
    luong float
);

create table chung_nhan (	
	ma_nv int not null,
    ma_mb int not null,
	constraint primary key (ma_nv, ma_mb),
	constraint foreign key chung_nhan_emp_fk (ma_nv) references nhan_vien (ma_nv),
	constraint foreign key chung_nhan_emp_fk (ma_mb) references may_bay (ma_mb)
);

/*

1. SELECT * FROM chuyen_bay where ga_den ('DAD'),

2. SELECT * FROM may_bay where tam_bay > 10.000,

3. SELECT * FROM nhan_vien where luong < 10.000,

4. SELECT * FROM chuyen_bay where do_dai between 8.000 and 10.000,

5. SELECT * FROM chuyen_bay where ga_di ('SGN') and ga_den ('BMV'),

6. SELECT * FROM chuyen_bay where count ( ga_di ('SGN') ),

7. SELECT * FROM may_bay where loai ('Boeing'),

8. SELECT * FROM nhan_vien where sum(luong),

9. SELECT ma_nv, loai FROM nhan_vien, may_bay where nhan_vien.ma_nv = may_bay.loai('Boeing'),

10. SELECT ten, ma_mb FROM nhan_vien, may_bay where nhan_vien.ten = may_bay.ma_mb('747'),

11. SELECT ten, loai FROM  nhan_vien, may_bay where nhan_vien.ten('Nguyen') = may_bay.loai,

12. SELECT ma_nv, loai FROM nhan_vien, may_bay where nhan_vien.ma_nv = may_bay.loai(('Boeing') and('Airbus'),

13. SELECT loai, ma_cb FROM may_bay, chuyen_bay where may_bay.loai = chuyen_bay.ma_cb('VN280'),

14. SELECT loai, ma_cb FROM may_bay, chuyen_bay where may_bay.loai('Airbus') = chuyen_bay.ma_cb('A320'),

15. SELECT ten, loai FROM nhan_vien, may_bay where nhan_vien.ten = may_bay.loai('Boeing'),

16. SELECT * FROM 

17. SELECT ga_di FROM

18. SELECT * FROM

19. SELECT * FROM 

20. SELECT * FROM chuyen_bay where gio_di < 12,

21. SELECT * FROM chuyen_bay where count ( gio_di <12),

22. SELECT ma_nv, loai FROM nhan_vien, may_bay where nhan_vien.ma_nv = may_bay.count(loai < 3),

23. SELECT * FROM 

24. SELECT ma_nv, loai FROM nhan_vien, may_bay where nhan_vien.ma_nv = may_bay.count( loai ),

25. SELECT * FROM 

26. SELECT * FROM nhan_vien where ma_nv = (luong = max)

27. SELECT * FROM 

28. SELECT * FROM chuyen_bay, may_bay where chuyen_bay = may_bay.loai('Boeing'),


