DROP DATABASE IF EXISTS DeAnCongTy;
CREATE DATABASE DeAnCongTy;
USE DeAnCongTy;

CREATE TABLE NHANVIEN (
                          HONV VARCHAR(15),
                          TENLOT VARCHAR(15),
                          TENNV VARCHAR(15),
                          MANV CHAR(9)NOT NULL,
                          NGSINH DATETIME,
                          DCHI VARCHAR(50),
                          PHAI CHAR(3) ,
                          LUONG FLOAT,
                          MA_NQL CHAR(9),
                          PHG INT
);

CREATE TABLE PHONGBAN (
                          TENPHG VARCHAR(15),
                          MAPHG INT NOT NULL,
                          TRPHG CHAR(9),
                          NG_NHANCHUC DATETIME

);

CREATE TABLE DIADIEM_PHG
(
    MAPHG INT  NOT NULL,
    DIADIEM VARCHAR(15) NOT NULL
);

CREATE TABLE PHANCONG
(
    MA_NVIEN CHAR(9) NOT NULL,
    SODA INT NOT NULL,
    THOIGIAN FLOAT
);

CREATE TABLE DEAN
(
    TENDA VARCHAR (15) ,
    MADA INT  NOT NULL,
    DDIEM_DA VARCHAR(15),
    PHONG INT
);

CREATE TABLE THANNHAN (
                          MA_NVIEN CHAR(9)  NOT NULL,
                          TENTN VARCHAR(15) NOT NULL,
                          PHAI	char(3),
                          NGSINH	DATETIME,
                          QUANHE	VARCHAR(8)

);

INSERT INTO NHANVIEN VALUES ('Pham','Van','Vinh',888665555, STR_TO_DATE('11/10/1937', '%d/%m/%Y'),'450 Trung Vuong,Ha Noi','Nam',55000, NULL,1);
INSERT INTO NHANVIEN VALUES ('Nguyen','Thanh','Tung',333445555, STR_TO_DATE('12/08/1955', '%d/%m/%Y'),'638 Nguyen Van Cu, Q5, TP HCM','Nam',4000,888665555,5);
INSERT INTO NHANVIEN VALUES ('Le','Quynh','Nhu',987654321, STR_TO_DATE('20/06/1951', '%d/%m/%Y'),'291 Ho Van Hue, QPN, TP HCM','Nu',43000,888665555,4);
INSERT INTO NHANVIEN VALUES ('Bui','Ngoc','Hang',999887777, STR_TO_DATE('19/07/1968', '%d/%m/%Y'),'638 Nguyen Van Cu,Q5, TP HCM','Nu',25000,987654321,4);
INSERT INTO NHANVIEN VALUES ('Nguyen','Manh','Hung',666884444, STR_TO_DATE('20/05/1951', '%d/%m/%Y'),'957 Ba Ria, Vung Tau','Nam',38000,333445555,5);
INSERT INTO NHANVIEN VALUES ('Tran','Thanh','Tam',453453453, STR_TO_DATE('30/06/1972', '%d/%m/%Y'),'543 Mai Thi Luu,Q1,TP HCM','Nam',38000,333445555,5);
INSERT INTO NHANVIEN VALUES ('Tran','Hong','Quang',987987987, STR_TO_DATE('03/09/1969', '%d/%m/%Y'),'980 Le Hong Phong,Q10,TPHCM','Nam',25000,333445555,4);
INSERT INTO NHANVIEN VALUES ('Dinh',' Ba', 'Tien', 123456789, STR_TO_DATE('01/09/1965', '%d/%m/%Y'),'731 Tran Hung Dao Q1 TP HCM' , 'Nam', 30000,333445555,5);

INSERT INTO PHONGBAN VALUES ( 'Nghien cuu', 5 ,333445555,STR_TO_DATE('05/22/1998', '%m/%d/%Y'));
INSERT INTO PHONGBAN VALUES ('Dieu Hang',4,987987987, STR_TO_DATE('01/01/1995', '%m/%d/%Y'));
INSERT INTO PHONGBAN VALUES ('Quan Li',1,888665555, STR_TO_DATE('06/19/1981', '%m/%d/%Y'));
INSERT INTO PHONGBAN VALUES ('Bao Ve',2,888665555,STR_TO_DATE('06/19/1981', '%m/%d/%Y'));

-- THEM DU LIEU VAO BANG THAN NHAN:
INSERT INTO THANNHAN VALUES(333445555,'Trinh','Nu',STR_TO_DATE('04/05/1986', '%m/%d/%Y'),'Con gai');
INSERT INTO THANNHAN VALUES(333445555,'Khang','Nam',STR_TO_DATE('10/25/1983', '%m/%d/%Y'),'Con trai');
INSERT INTO THANNHAN VALUES(333445555,'Phuong','Nu',STR_TO_DATE('05/03/1958', '%m/%d/%Y'),'Vo chong');
INSERT INTO THANNHAN VALUES(987654321,'Minh','Nam',STR_TO_DATE('02/28/1942', '%m/%d/%Y'),'Vo chong');
INSERT INTO THANNHAN VALUES(123456789,'Tien','Nam',STR_TO_DATE('01/01/1988', '%m/%d/%Y'),'Con trai');
INSERT INTO THANNHAN VALUES(123456789,'Chau','Nu',STR_TO_DATE('12/30/1988', '%m/%d/%Y'),'Con gai');
INSERT INTO THANNHAN VALUES(123456789,'Phuong','Nu',STR_TO_DATE('05/05/1967', '%m/%d/%Y'),'Vo chong');

-- THEM DU LIEU VAO BANG DEAN:
INSERT INTO DEAN VALUES ('San pham X',1,'VUNG TAU',5);
INSERT INTO DEAN VALUES ('San pham Y',2,'Nha Trang',5);
INSERT INTO DEAN VALUES ('San pham Z',3,'TP HCM',5);
INSERT INTO DEAN VALUES ('Tin Hoc Hoa',10,'HA NOI',4);
INSERT INTO DEAN VALUES ('Cap Quang',20,'TP HCM',1);
INSERT INTO DEAN VALUES ('Dao Tao',30,'HA NOI',4);

-- THAM DU LIEU VAO BANG PHANCONG:

INSERT INTO PHANCONG VALUES (123456789,1,32.5);
INSERT INTO PHANCONG VALUES (123456789,2,7.5);
INSERT INTO PHANCONG VALUES (666884444,3,40.0);
INSERT INTO PHANCONG VALUES (453453453,1,20.0);
INSERT INTO PHANCONG VALUES (453453453,2,20.0);
INSERT INTO PHANCONG VALUES (333445555,2,10.0);
INSERT INTO PHANCONG VALUES (333445555,3,10.1);
INSERT INTO PHANCONG VALUES (333445555,10,10.0);
INSERT INTO PHANCONG VALUES (333445555,20,10.0);
INSERT INTO PHANCONG VALUES (999887777,30,30.0);
INSERT INTO PHANCONG VALUES (999887777,10,10.0);
INSERT INTO PHANCONG VALUES (987987987,10,35.0);
INSERT INTO PHANCONG VALUES (987987987,30,5.0);
INSERT INTO PHANCONG VALUES (987654321,30,20.0);
INSERT INTO PHANCONG VALUES (987654321,20,15.0);
INSERT INTO PHANCONG VALUES (888665555,20,NULL);

-- THEM DU LIEU VAO BANG DIADIEM_PHG:
INSERT INTO DIADIEM_PHG VALUES(1,'TP HCM');
INSERT INTO DIADIEM_PHG VALUES(4,'HA NOI');
INSERT INTO DIADIEM_PHG VALUES(5,'VUNG TAU');
# INSERT INTO DIADIEM_PHG VALUES(5,'NHA TRANG');
# INSERT INTO DIADIEM_PHG VALUES(5,'TP HCM');

-- KHI XOA BANG BANG NAO DUOC THAM CHIEU THI PHAI XOA KHOA NGOAI THAM CHIEU DEN NO RUI MOI XOA NO
-- THEM RANG BUOC KHOA CHINH CHO CAC BANG:
ALTER TABLE NHANVIEN ADD CONSTRAINT PK_MANV PRIMARY KEY (MANV);
ALTER TABLE PHONGBAN ADD CONSTRAINT PK_MAPHG PRIMARY KEY (MAPHG);
ALTER TABLE DIADIEM_PHG ADD CONSTRAINT PK_MAPHG_DIADIEM PRIMARY KEY (MAPHG,DIADIEM);
ALTER TABLE DEAN ADD CONSTRAINT PK_MADA PRIMARY KEY (MADA);
ALTER TABLE PHANCONG ADD CONSTRAINT PK_PHANCONG_MA_NVIEN_SODA PRIMARY KEY(MA_NVIEN,SODA);
ALTER TABLE THANNHAN ADD CONSTRAINT PK_MANVIEN_TENTN PRIMARY KEY(MA_NVIEN,TENTN);
-- THEM RANG BUOC KHOA NGOAI CHO CAC BANG :
ALTER TABLE NHANVIEN ADD CONSTRAINT FK_NHANVIEN_PHG_PHONGBAN FOREIGN KEY (PHG)REFERENCES PHONGBAN(MAPHG);
ALTER TABLE NHANVIEN ADD CONSTRAINT FK_NHANVIEN_MA_NQL_NHANVIEN FOREIGN KEY(MA_NQL) REFERENCES NHANVIEN(MANV);
ALTER TABLE PHONGBAN ADD CONSTRAINT FK_PHONGBAN_TRPHG_NHANVIEN FOREIGN KEY (TRPHG)REFERENCES NHANVIEN(MANV);
ALTER TABLE DIADIEM_PHG ADD CONSTRAINT FK_DIEMDIEM_PHG_MAPHG_PHONGBAN FOREIGN KEY (MAPHG)REFERENCES PHONGBAN(MAPHG);
ALTER TABLE DEAN ADD CONSTRAINT FK_DEAN_PHONG_PHONGBAN FOREIGN KEY (PHONG) REFERENCES PHONGBAN(MAPHG);
ALTER TABLE PHANCONG
    ADD CONSTRAINT FK_PHANCONG_MA_NVIEN_NHANVIEN FOREIGN KEY (MA_NVIEN) REFERENCES NHANVIEN(MANV),
    ADD CONSTRAINT FK_PHANCONG_SODA_DEAN FOREIGN KEY(SODA) REFERENCES DEAN(MADA);
ALTER TABLE THANNHAN ADD CONSTRAINT FK_THANNHAN_MANVIEN_NHANVIEN FOREIGN KEY (MA_NVIEN)REFERENCES NHANVIEN(MANV);
-- THEM RANG BUOC CHECK VAO CAC THUOC TINH CUA CAC BANG:
ALTER TABLE NHANVIEN ADD CONSTRAINT CHK_NHANVIEN_PHAI CHECK(PHAI IN('NAM','NU'));
ALTER TABLE PHONGBAN ADD CONSTRAINT UNI_PHONGBAN_TENPHG UNIQUE(TENPHG);
# ALTER TABLE PHANCONG ADD CONSTRAINT CHK_PHANCONG_THOIGIAN CHECK (THOIGIAN IN(1,5));
# ALTER TABLE PHANCONG DROP CONSTRAINT CHK_PHANCONG_THOIGIAN;

-- Truy vấn đơn giản
-- 1. Tìm các nhân viên làm việc ở phòng số 4
select * from nhanvien where phg = '4';

-- 2. Tìm các nhân viên có mức lương trên 30000
select * from nhanvien where luong>3000 ;
-- 3. Tìm các nhân viên có mức lương trên 25,000 ở phòng 4 hoặc các nhân viên có mức lương trên 30,000 ở phòng 5
select * from nhanvien where (phg = '4' and luong> 25000) or (phg = '5' and luong> 30000) ;
-- 4. Cho biết họ tên đầy đủ của các nhân viên ở TP HCM
select honv , tenlot , tennv  from nhanvien where dchi like '%HCM';
-- 5. Cho biết họ tên đầy đủ của các nhân viên có họ bắt đầu bằng ký tự ‘N’
select honv , tenlot , tennv  from nhanvien where tennv like  'N%';
-- 6. Cho biết ngày sinh và địa chỉ của nhân viên Dinh Ba Tien
select ngsinh, dchi from nhanvien nv where nv.honv= 'Dinh' and nv.tenlot= ' Ba' and nv.tennv= 'Tien';
-- 7. Cho biết các nhân viên có năm sinh trong khoảng 1960 đến 1965
select * from nhanvien where year(ngsinh) between '1960' and '1965';
-- 8. Cho biết các nhân viên và năm sinh của nhân viên
select tennv, year(ngsinh) as namsinh from nhanvien;
-- 9. Cho biết các nhân viên và tuổi của nhân viên
select tennv, ( 2023- year(ngsinh)) as tuoi  from nhanvien;
-- Truy vấn có sử dụng phép kết
-- 10. Với mỗi phòng ban, cho biết tên phòng ban và địa điểm phòng
select pb.tenphg, ddp.diadiem from phongban pb, diadiem_phg ddp;
-- 11. Tìm tên những người trưởng phòng của từng phòng ban
select nv.tennv, pb.TENPHG from nhanvien nv, phongban 
    join phongban pb on nv.phg= pb.maphg and nv.manv= pb.trphg;
-- 12. Tìm tên và địa chỉ của tất cả các nhân viên của phòng "Nghiên cứu".
select tennv, dchi from nhanvien, phongban where nv.maphg=pb.phg and tenphg= 'Nghien cuu';
-- 13. Với mỗi đề án ở Hà Nội, cho biết tên đề án, tên phòng ban, họ tên và ngày nhận chức của trưởng phòng của phòng ban chủ trì đề án đó.
select da.TENDA, pb.tenphg, nv.honv, nv.tennv, pb.NG_NHANCHUC from nhanvien nv, phongban pb, dean da
where nv.phg= pb.maphg and nv.manv= pb.trphg
and da.DDIEM_DA = 'HA NOI';
-- 14. Tìm tên những nữ nhân viên và tên người thân của họ
select nv.tennv, tn.tentn from nhanvien nv, thannhan tn where nv.phai= 'NU';
-- 15. Với mỗi nhân viên, cho biết họ tên nhân viên và họ tên người quản lý trực tiếp của nhân viên đó
select nv.tennv as nhanvien, ql.tennv as quanly from nhanvien nv, nhanvien ql 
where ql.manv= nv.MA_NQL;
-- 16. Với mỗi nhân viên, cho biết họ tên của nhân viên đó, họ tên người trưởng phòng và họ tên người quản lý trực tiếp của nhân viên đó.
select nv.tennv as nhanvien, tp.tennv as truongphong, ql.tennv from nhanvien nv, nhanvien tp, nhanvien ql, phongban pb
where nv.phg= pb.maphg and nv.manv= pb.trphg and ql.manv= nv.MA_NQL;
-- 17. Tên những nhân viên phòng số 5 có tham gia vào đề án "San pham X" và nhân viên này do "Nguyen Thanh Tung" quản lý trực tiếp.
select nv.tennv from nhanvien nv
	join nhanvien ql 
		on nv.MA_NQL=ql.MANV
		and ql.TENNV='Tung'
		and ql.HONV='Nguyen'
		and ql.TENLOT='Thanh'
	join phancong pc on pc.MA_NVIEN=nv.MANV 
	join dean da on da.MADA=pc.SODA and da.TENDA='San pham X' and da.PHONG='5';
-- 18. Cho biết tên các đề án mà nhân viên Đinh Bá Tiến đã tham gia.
select da.* from nhanvien nv
join phancong pc on pc.MA_NVIEN= nv.MANV
join dean da on da.PHONG= pc.SODA 
where nv.HONV= 'Dinh' and nv.TENLOT='Ba' and nv.TENNV='Tien';
-- GOM NHÓM
-- 19. Cho biết số lượng đề án của công ty
select count(*) as sldean from dean;

-- 20. Cho biết số lượng đề án do phòng ‘Nghiên Cứu’ chủ trì
select tenda, count(dean.phong) as sldean from dean, phongban where dean.phong= phongban.maphg
 and phongban.tenphg = 'NGHIEN CUU'
 group by tenda;
-- 21. Cho biết lương trung bình của các nữ nhân viên
select avg(luong) as trungbinhluong from nhanvien where nhanvien.phai= 'NU';
-- 22. Cho biết số thân nhân của nhân viên ‘Đinh Bá Tiến’
select count(tentn) as sotn from thannhan, nhanvien where nhanvien.manv= thannhan.ma_nvien 
and nhanvien.tennv= 'Tien';
-- 23. Với mỗi đề án, liệt kê tên đề án và tổng số giờ làm việc một tuần của tất cả các nhân viên tham dự đề án đó.
select da.tenda, pc.thoigian, nv.tennv from dean da, phancong pc, nhanvien nv 
where nv.manv= pc.ma_nvien and pc.soda= da.mada;
-- 24. Với mỗi đề án, cho biết có bao nhiêu nhân viên tham gia đề án đó
select da.tenda, count(pc.ma_nvien) as tongnhanvien from  dean da, phancong pc
where  pc.soda= da.mada
group by da.tenda ;
-- 25. Với mỗi nhân viên, cho biết họ và tên nhân viên và số lượng thân nhân của nhân viên đó.
select nv.tennv, count(tn.ma_nvien) as sltn from nhanvien nv, thannhan tn
where nv.manv=tn.ma_nvien
group by nv.tennv;
-- 26. Với mỗi nhân viên, cho biết họ tên của nhân viên và số lượng đề án mà nhân viên đó đã tham gia.
select nv.tennv, count(da.mada) as slda from nhanvien nv, dean da, phancong pc
where  nv.manv= pc.ma_nvien and pc.soda= da.mada
group by tennv;
-- 27. Với mỗi phòng ban, cho biết tên phòng ban và số lượng đề án mà phòng ban đó chủ trì
select pb.tenphg, count(da.phong) as slda from phongban pb, dean da
where pb.maphg= da.phong
group by tenphg;
-- 28. Với mỗi phòng ban, cho biết tên phòng ban, họ tên người trưởng phòng và số lượng đề án mà phòng ban đó chủ trì
select pb.tenphg, nv.tennv as truongphong, count(da.phong) as slda from phongban pb, dean da, nhanvien nv
where pb.maphg= da.phong and nv.manv= pb.TRPHG
group by pb.tenphg, nv.tennv;
-- 29. Với mỗi phòng ban có mức lương trung bình lớn hơn 40,000, cho biết tên phòng ban và số lượng đề án mà phòng ban đó chủ trì.
select pb.tenphg, count(da.phong) as slda from phongban pb, dean da, nhanvien nv
where nv.phg=pb.maphg and pb.maphg= da.phong 
group by tenphg
having avg(nv.luong)>40000;

-- 30. Cho biết số đề án diễn ra tại từng địa điểm
select da.DDIEM_DA, count(da.tenda) as slda from dean da
group by da.ddiem_da;
-- 31. Với mỗi đề án, cho biết tên đề án và số lượng công việc của đề án này.
select tenda, count(mada) as slcv from dean da
group by tenda;
-- 32. Với mỗi công việc trong đề án có mã đề án là 30, cho biết số lượng nhân viên được phân công .
select count(nv.manv) as slnv from nhanvien nv, dean da, phancong pc
where da.mada= '30' and nv.manv= pc.ma_nvien and pc.soda= da.mada;
-- 33. Với mỗi công việc trong đề án có mã đề án là ‘Dao Tao’, cho biết số lượng nhân viên được phân công.
select count(nv.manv) as slnv from nhanvien nv, dean da, phancong pc
where da.tenda= 'Dao Tao' and nv.manv= pc.ma_nvien and pc.soda= da.mada;
-- TRUY VẤN LỒNG + GOM NHÓM
-- 34. Cho biết danh sách các đề án (MADA) có: nhân công với họ (HONV) là ‘Dinh’ hoặc , có người trưởng phòng chủ trì đề án với họ (HONV) là ‘Dinh’.
select da.tenda from dean da, nhanvien nv
where da.phong= nv.phg and nv.honv = 'Dinh'
union
select da.tenda from dean da, nhanvien nv, phongban pb
where nv.manv=pb.trphg and da.phong= nv.phg and nv.honv = 'Dinh';
-- 35. Danh sách những nhân viên (HONV, TENLOT, TENNV) có trên 2 thân nhân.
select nv.honv, nv.tenlot, nv.tennv from nhanvien nv, thannhan tn
where nv.manv=tn.ma_nvien 
group by nv.honv, nv.tenlot, nv.tennv
having count(tn.ma_nvien)>2;
-- 36. Danh sách những nhân viên (HONV, TENLOT, TENNV) không có thân nhân nào.
select distinct nv.honv, nv.tenlot, nv.tennv from nhanvien nv, thannhan tn
where nv.manv not in (select tn.ma_nvien from nhanvien nv, thannhan tn where nv.manv=tn.ma_nvien);
-- 37. Danh sách những trưởng phòng (HONV, TENLOT, TENNV) có tối thiểu một thân nhân.
select nv.honv, nv.tenlot, nv.tennv from nhanvien nv, thannhan tn
where nv.manv=tn.ma_nvien 
group by nv.honv, nv.tenlot, nv.tennv
having count(tn.ma_nvien)>=1;
-- 38. Tìm họ (HONV) của những trưởng phòng chưa có gia đình.
select distinct nv.honv from nhanvien nv, phongban pb, thannhan tn
where nv.manv=pb.trphg and pb.trphg not in (
 select pb.trphg from phongban pb, thannhan tn where pb.trphg = tn.ma_nvien and tn.quanhe= 'Vo chong');
-- 39. Cho biết họ tên nhân viên (HONV, TENLOT, TENNV) có mức lương trên mức lương trung bình của phòng "Nghiên cứu"
select nv.HONV, nv.TENLOT, nv.TENNV from nhanvien nv, phongban pb
where nv.luong > (select avg(nv.luong) from nhanvien nv, phongban pb 
where nv.phg= pb.maphg and pb.tenphg = ' Nghien cuu');
-- 40. Cho biết tên phòng ban và họ tên trưởng phòng của phòng ban có đông nhân viên nhất.
