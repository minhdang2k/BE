
create database hangkhong;

 

use hangkhong;

 

create table hangkhong.CHUYENBAY (

	MaCB varchar(5) primary key,

	GaDi varchar(10) not null,

	GaDen varchar(10) not null,

	DoDai int not null,

	GioDi time not null,

	GioDen time not null,

	ChiPhi int not null

);

 

create table hangkhong.NHANVIEN (

	MaNV varchar(15) not null,

	Ten varchar(50) not null,

	Luong int not null,

	primary key (MaNV)

);

 

create table hangkhong.MAYBAY 

(

	MaMB varchar(5) primary key,

	Loai varchar(20) not null,

	TamBay int not null

);

 

create table hangkhong.CHUNGNHAN (

	MaMB varchar(5) not null,

	MaNV varchar(15) not null,

	primary key (MaMB, MaNV),

	CONSTRAINT chungnhan_maybay_fk foreign key (MaMB) references hangkhong.MAYBAY(MaMB),

	CONSTRAINT chungnhan_nhanvien_fk foreign key (MaNV) references hangkhong.NHANVIEN(MaNV)

);

insert into hangkhong.CHUYENBAY
values
('VN431', 'SGN','CAH',3693,'05:55','06:55',236),
('VN464','SGN','DLI',2002,'07:20','08:05',225),
('VN216','SGN','DIN',4170,'10:30','14:20',262),
('VN280','SGN','HPH',11979,'06:00','08:00',1279),
('VN254','SGN','HUI',8765,'18:40','20:00',781),
('VN338','SGN','BMV',4081,'15:25','16:25',375),
('VN440','SGN','BMV',4081,'18:30','19:30',426),
('VN651','DAD','SGN',2798,'19:30','08:00',221),
('VN276','DAD','CXR',1283,'09:00','12:00',203),
('VN374','HAN','VII',510,'11:40','13:25',120),
('VN375','VII','CXR',752,'14:15','16:00',181),
('VN269','HAN','CXR',1262,'14:10','15:50',202),
('VN315','HAN','DAD',134,'11:45','13:00',112),
('VN317','HAN','UIH',827,'15:00','16:15',190),
('VN741','HAN','PXU',395,'06:30','08:30',120),
('VN474','PXU','PQC',1586,'08:40','11:20',102),
('VN476','UIH','PQC',485,'09:15','11:50',117);

insert into hangkhong.MAYBAY
values 
(747, 'Boeing 747 - 400', 13488),
(737, 'Boeing 737 - 800', 5413),
(340, 'Airbus A340 - 300', 11392),
(757, 'Boeing 757 - 300', 6416),
(777, 'Boeing 777 - 300', 10306),
(767, 'Boeing 767 - 400E', 10360),
(320, 'Airbus A320', 4168),
(319, 'Airbus A319', 2888),
(727, 'Boeing 727', 2406),
(154, 'Tupolev 154', 6565);

insert into hangkhong.NHANVIEN
values
(242518965,'Tran Van Son',120433),
(141582651,'Doan Thi Mai',178345),
(011564812,'Ton Van Quy',153972),
(567354612,'Quan Cam Ly',256481),
(552455318,'La Que',101745),
(550156548,'Nguyen Thi Cam',205187),
(390487451,'Le Van Luat',212156),
(274878974,'Mai Quoc Minh',99890),
(254099823,'Nguyen Thi Quynh',24450),
(356187925,'Nguyen Vinh Bao',44740),
(355548984,'Tran Thi Hoai An',212156),
(310454876,'Ta Van Do',212156),
(489456522,'Nguyen Thi Quy Linh',127984),
(489221823,'Bui Quoc Chinh',23980),
(548977562,'Le Van Quy',84476),
(310454877,'Tran Van Hao',33546),
(142519864,'Nguyen Thi Xuan Dao',227489),
(269734834,'Truong Tuan Anh',289950),
(287321212,'Duong Van Minh',48090),
(552455348,'Bui Thi Dung',92013),
(248965255,'Tran Thi Ba',43723),
(159542516,'Le Van Ky',48250),
(348121549,'Nguyen Van Thanh',32899),
(574489457,'Dui Van Lap',20);

insert into hangkhong.CHUNGNHAN(MaNV, MaMB)
values
 (567354612,747),
(567354612,737),
(567354612,757),
(567354612,777),
(567354612,767),
(567354612,727),
(567354612,340),
(552455318,737),
(552455318,319),
(552455318,747),
(552455318,767),
(390487451,340),
(390487451,320),
(390487451,319),
(274878974,757),
(274878974,767),
(355548984,154),
(310454876,154),
(142519864,747),
(142519864,757),
(142519864,777),
(142519864,767),
(142519864,737),
(142519864,340),
(142519864,320),
(269734834,747),
(269734834,737),
(269734834,340),
(269734834,757),
(269734834,777),
(269734834,767),
(269734834,320),
(269734834,319),
(269734834,727),
(269734834,154),
(242518965,737),
(242518965,757),
(141582651,737),
(141582651,757),
(141582651,767),
(011564812,737),
(011564812,757),
(574489457,154);

-- 1. Cac chuyen bay di Da lat
select * from chuyenbay where GaDen = 'DAD';
-- 2. Cho biết các loại máy bay có tầm bay lớn hơn 10,000km
select * from maybay where TamBay > 10000;
-- 3. Tìm các nhân viên có lương nhỏ hơn 10,000
select * from nhanvien where luong < 10000;
-- 4. Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
select * from chuyenbay where dodai between 8000 and 10000;
-- 5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
select * from chuyenbay where gadi = ('SGN') and gaden= ('BMV');
-- 6. Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
select count(MaCB) from chuyenbay where gadi = ('SGN');
-- 7. Có bao nhiêu loại máy báy Boeing
select count(MaMB) from maybay where loai like '%Boeing%';
-- 8. Cho biết tổng số lương phải trả cho các nhân viên
select sum(luong) from nhanvien;
-- 9. Cho biết mã số của các phi công lái máy báy Boeing. su lung cau lenh join
select distinct maNV from chungnhan
inner join maybay on chungnhan.MaMB= maybay.MaMB
where maybay.Loai like '%Boeing%';
-- 10. Cho biết các nhân viên có thể lái máy bay có mã số 747.
select * from nhanvien
join chungnhan on nhanvien.MaNV= chungnhan.MaNV
where chungnhan.MaMB =('747');
-- 11. Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
select * from chungnhan 
join nhanvien on chungnhan.MaNV = nhanvien.MaNV
where nhanvien.ten like '%Nguyen%'; 
-- 12. Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
select distinct dspcboeing.MaNV from (
	select chungnhan.MaNV from chungnhan
	join maybay on chungnhan.MaMB= maybay.MaMB
	where maybay.loai like '%Boeing%') as dspcboeing
join
(
	select chungnhan.MaNV from chungnhan
	join maybay on chungnhan.MaMB= maybay.MaMB
	where maybay.loai like '%Airbus%') as dspcairbus
on dspcboeing.manv= dspcairbus.manv;
-- 13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
select maybay.loai as loaimaybay from maybay
where Tambay> (select dodai from chuyenbay where maCB=('VN280'));
-- 14. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
select * from chuyenbay
where dodai< (select tambay from maybay where loai like '%Airbus A320%');
-- 15. Cho biết tên của các phi công lái máy bay Boeing.
select distinct nhanvien.ten from nhanvien
 join chungnhan on nhanvien.MaNV= chungnhan.MaNV
 join maybay on chungnhan.MaMB= maybay.MaMB
where maybay.loai like '%Boeing%';
-- 16. Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.
select maybay.MaMB, maybay.loai,
 (select count(*)  from chungnhan where chungnhan.maMB= maybay.MaMB) as tongphicong from maybay;
-- 17. Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các đường bay nào có thể đáp ứng yêu cầu này
select * from chuyenbay where Gadi in (select Gaden from chuyenbay) and Gaden in(select Gadi from chuyenbay);
-- 18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.
select cb.gadi, count(cb.gadi) as tongcb from chuyenbay cb
group by gadi; 
-- 19. Với mỗi ga có chuyến bay xuất phát từ đó cho biết tổng chi phí phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.
select cb.gadi, sum(cb.chiphi) as tongcp from chuyenbay cb
group by gadi;
-- 20. Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
select * from chuyenbay where GioDi < '12:00';
-- 21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
select cb.gadi, count(cb.gadi) as tongcb from chuyenbay cb where giodi<'12:00'
group by gadi;
-- 22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay. 
select nhanvien.MaNV from nhanvien
join chungnhan on nhanvien.MaNV= chungnhan.MaNV
join maybay on chungnhan.MaMB= maybay.MaMB
group by nhanvien.MaNV
having count(maybay.mamb)=3;
-- 23. Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay mà phi công đó có thể lái.
select nv.manv, max(mb.tambay) from nhanvien nv, chungnhan cn, maybay mb
where nv.manv=cn.MaNV and cn.mamb= mb.mamb 
group by cn.manv
having count(mb.mamb) > 3 ;
-- 24. Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái.
select nv.MaNV, nv.ten, count(mb.MaMB) as tsmb from nhanvien nv, chungnhan cn, maybay mb
where nv.MaNV= cn.MaNV 
and mb.MaMB= cn.MaMB
and nv.MaNV in(select MaNV from chungnhan)
group by nv.manv, nv.ten;
-- 25. Tìm các nhân viên không phải là phi công.
select * from nhanvien where manv not in( select manv from chungnhan);
-- 26. Cho biết mã số của các nhân viên có lương cao nhất.
select manv from nhanvien where luong = (select max(luong) from nhanvien);
-- 27. Cho biết tổng số lương phải trả cho các phi công.
select sum(luong) as luongphicong from nhanvien where manv in ( select manv from chungnhan);
-- 28. Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing
SELECT DISTINCT cb.* FROM CHUYENBAY cb, MAYBAY mb WHERE DoDai < TamBay AND Loai Like 'Boeing%'


