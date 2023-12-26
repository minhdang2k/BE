package DangTieuMinh_JavaSE_Final_Test.Ex2.service.impl;

import DangTieuMinh_JavaSE_Final_Test.Ex2.dao.Dao;
import DangTieuMinh_JavaSE_Final_Test.Ex2.exception.InvalidInputException;
import DangTieuMinh_JavaSE_Final_Test.Ex2.model.Employee;
import DangTieuMinh_JavaSE_Final_Test.Ex2.service.EmployeeService;
import Lab10test.utils.Validator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee>  employees= new ArrayList<>();
    private Dao<Employee> employeeDao;

    public EmployeeServiceImpl(List<Employee> employees, Dao<Employee> employeeDao) {
        this.employees = employees;
        this.employeeDao = employeeDao;
    }

    public EmployeeServiceImpl(Dao<Employee> employeeDao) {
    }

    public void createEmployee(Scanner scanner, Employee employee){
        System.out.println("----NHAP THONG TIN NHAN VIEN----");
        System.out.println("Nhap MaNV: ");
        employee.setMaNV(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Nhap ho va ten lot: ");
        employee.setHo_tenLot(scanner.nextLine());
        System.out.println("Nhap ten: ");
        employee.setTen(scanner.nextLine());
        System.out.println("Nhap ngay sinh: ");
        employee.setNgaySinh(scanner.nextLine());
        System.out.println("Nhap email: ");
        employee.setEmail(scanner.nextLine());
        System.out.println("Nhap so dien thoai: ");
        String phone= scanner.nextLine();
        if (!Validator.isPhone(phone)){
            throw new InvalidInputException("So dien thoai khong hop le!!");
        }
        employee.setPhone(phone);
        System.out.println("Nhap luong");
        employee.setLuong(scanner.nextInt());
        scanner.nextLine();
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void display(List<Employee> employees) {
        System.out.println("----DANH SACH NHAN VIEN----");
        System.out.println(employees);
    }

    @Override
    public boolean removeEmployee(String phone) {
        return employees.removeIf(employee -> employee.getPhone().equals(phone));
    }
}
