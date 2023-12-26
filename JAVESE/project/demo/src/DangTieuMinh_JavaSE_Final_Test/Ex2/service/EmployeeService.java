package DangTieuMinh_JavaSE_Final_Test.Ex2.service;

import DangTieuMinh_JavaSE_Final_Test.Ex2.model.Employee;

import java.util.List;
import java.util.Scanner;

public interface EmployeeService {
    void createEmployee(Scanner scanner, Employee employee);
    List<Employee> findAll();
    void display(List<Employee> employees);
    boolean removeEmployee(String phone);
}
