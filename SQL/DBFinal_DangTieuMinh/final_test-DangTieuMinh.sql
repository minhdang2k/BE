create schema ftest;

use ftest;


create table lap_trinh_vien (
	programmer_id int primary key auto_increment,
    ho varchar(50),
    ten_lot varchar(50),
	ten varchar(50),
    gioi_tinh varchar(10),
    email varchar(100),
    chuc_danh varchar(50),
    luong float,
    ngay_thue date
    );
    
create table nn_lap_trinh (
	nn_id int primary key auto_increment,
    programmer_id int,
    ten_nn varchar(100),
    ngay_lam_viec date,
    constraint foreign key nn_ltv_fk (programmer_id) references lap_trinh_vien(programmer_id)
    );
-- 1. Sử dụng câu lệnh DDL để thêm một cột dữ liệu mới có lên “description” có kiểu chuỗi vào bảng ProgramningLanguage
ALTER TABLE nn_lap_trinh

add description varchar(100) ;

-- 2. Sử dụng câu lệnh DML để thêm dữ liệu vào tất cả các bảng (Table) (Mỗi bảng có ít nhất 5 mẫu tin).
INSERT INTO lap_trinh_vien VALUES (111222333,'Dang','Tieu','Minh','Nam','minhdang2804@gmail.com','Project Manager',55000, '2019-01-27');
INSERT INTO lap_trinh_vien VALUES (222333444,'Le','Nam','Phu','Nam','phulenam2k3@gmail.com','Developer',15000, '2023-04-20');
INSERT INTO lap_trinh_vien VALUES (555666777,'Le','Dieu','Hanh','Nu','dieuhanh31@gmail.com','Testter',20000, '2022-03-20');
INSERT INTO lap_trinh_vien VALUES (333444555,'Van','Anh','Quoc','Nam','anhquoc@gmail.com','Developer',25000, '2022-01-07');
INSERT INTO lap_trinh_vien VALUES (444555666,'Pham','Van','Huy','Nam','huypham222@gmail.com','Team Leader',40000, '2020-02-03');
INSERT INTO lap_trinh_vien VALUES (666777888,'Cristan','Lerbon','Jame','Nu','Jamejj@gmail.com','Team Leader',30000, '2022-09-25');

INSERT INTO nn_lap_trinh VALUES (1,111222333,'Python','2019-01-27');
INSERT INTO nn_lap_trinh VALUES (2,111222333,'C#','2020-02-28');
INSERT INTO nn_lap_trinh VALUES (3,111222333,'Java','2022-10-16');
INSERT INTO nn_lap_trinh VALUES (4,222333444,'Python','2023-04-20');
INSERT INTO nn_lap_trinh VALUES (5,555666777,'Java','2023-04-20');
INSERT INTO nn_lap_trinh VALUES (6,333444555,'C#','2022-01-07');
INSERT INTO nn_lap_trinh VALUES (7,444555666,'Python','2020-02-03');
INSERT INTO nn_lap_trinh VALUES (8,444555666,'C#','2022-03-04');
INSERT INTO nn_lap_trinh VALUES (9,666777888,'C#','2022-09-25');

-- 3. Viết câu lệnh SQL hiển thị tất cả lập trình viên có chức danh “ Team Leader” sắp xếp theo tên lập trình viên tăng dần.
select * from lap_trinh_vien where chuc_danh= 'Team Leader'
order by ten asc;

-- 4. Viết câu lệnh SQL liệt kê danh sách tất cả lập trình viên có tên chứ từ khóa “Jame”.
select * from lap_trinh_vien where ten like '%Jame%';

-- 5. Viết câu lệnh SQL liệt kê tất cả các lập trình viên có giới tính là nữ sắp xếp dữ liệu thoe ngày thuê giảm dần
select * from lap_trinh_vien where gioi_tinh= 'Nu'
order by ngay_thue desc;

-- 6. Viết câu lệnh SQL liệt kê các chức danh (Tester, Developer, Team leader, Project Manager) và số lượng lập trình viên có chức danh tương ứng.
select chuc_danh, count(programmer_id) as sl from lap_trinh_vien where chuc_danh='Testter' or chuc_danh='Team Leader' or chuc_danh='Developer' or chuc_danh='Project Manager'
group by chuc_danh;
-- 7. Viết câu lệnh SQL thống kê tổng lương, lương trung bình, lương thấp nhất, lương cao nhất của lập trình viên.
select sum(luong) as tongluong, avg(luong) as luongtb,
min(luong) as luongmin, max(luong) as luongmax from lap_trinh_vien;

-- 8. Viết câu lệnh SQL liệt kê danh sách lập trình viên có mức lương lớn hơn 400 USD và nhỏ hơn 1500 USD (Sắp xếp dữ liệu theo lương giảm dần, tên nhân viên tăng dần).
select * from lap_trinh_vien where luong between 40000 and 150000
order by luong desc, ten asc;

-- 9. Viết câu lệnh SQL liệt kê tất cả lập trình viên không có email (không có giá trị tại thuộc tính email).
select * from lap_trinh_vien where email = null;

-- 10. Viết câu lệnh SQL liệt kê tất cả ngôn ngữ lập trình và số lượng lập trình viên biết sử dụng ngôn ngữ lập trình để làm việc.
select ten_nn, count(programmer_id) as sl from nn_lap_trinh
group by ten_nn;
-- 11. Viết câu lệnh SQL liệt kê danh sách lập trình viên có khả năng sử dụng ngôn ngữ “C#” và “Java” để làm việc.
select * from lap_trinh_vien ltv
join nn_lap_trinh nn on ltv.programmer_id= nn.programmer_id
where ten_nn='Java' and ten_nn='C#';
-- 12. Viết câu lệnh SQL liệt kê danh sách các ngôn ngữ lập trình mà không có lập trình viên nào biết sử dụng để làm việc.
select * from lap_trinh_vien ltv, nn_lap_trinh nn
where nn.programmer_id not in (select ltv.programmer_id from lap_trinh_vien ltv, nn_lap_trinh nn
 where nn.programmer_id=ltv.programmer_id);
-- 13. Viết câu lệnh SQL liệt kê nhân viên có khả năng sử dụng nhiều ngôn ngữ lập trình nhất để làm việc
select *, count(nn.programmer_id) as sl from nn_lap_trinh nn
join lap_trinh_vien ltv on ltv.programmer_id=nn.programmer_id
where max(count(sl));
-- 14. Viết câu lệnh SQL liệt kê danh sách nhân viên (ID, last name, first name), số lượng ngôn ngữ lập trình có trả năng làm việc. (Chỉ liệt kê những nhân viên biết sử dụng từ 3 ngôn ngữ lập trình trở lên).
select ltv.programmer_id, ltv.ho, ltv.ten, count(nn.programmer_id) as sl from lap_trinh_vien ltv 
join nn_lap_trinh nn on ltv.programmer_id= nn.programmer_id 
group by ltv.programmer_id, ltv.ho, ltv.ten
having count(nn.programmer_id)>=3;
-- 15. Tạo view “employeeSkill” lưu trữ danh sách lập trình viên (id, last name, first name) và số lượng ngôn ngữ lập trình mà họ biết để sử dụng để làm việc.
select ltv.programmer_id, ltv.ho, ltv.ten, count(nn.programmer_id) as slnn from lap_trinh_vien ltv
join nn_lap_trinh nn on ltv.programmer_id= nn.programmer_id
group by ltv.programmer_id, ltv.ho, ltv.ten;
-- 16. Viết câu lệnh DML tăng lương thêm 10% cho tất cả các nhân viên có mức lương nhỏ hơn 30000 USD
update lap_trinh_vien
set luong = luong + luong * 0.1
where luong<30000;
-- 17. Viết câu lệnh DML xóa tất cả các ngôn ngữ lập trình mà không có lập trình viên nào biết sử dụng để làm việc.
delete from nn_lap_trinh
where 