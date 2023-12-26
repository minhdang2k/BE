package DangTieuMinh_JavaSE_Final_Test.Ex2;

import DangTieuMinh_JavaSE_Final_Test.Ex2.dao.Dao;
import DangTieuMinh_JavaSE_Final_Test.Ex2.dao.DaoImpl.EmployeeDaoImpl;
import DangTieuMinh_JavaSE_Final_Test.Ex2.exception.InvalidInputException;
import DangTieuMinh_JavaSE_Final_Test.Ex2.model.Employee;
import DangTieuMinh_JavaSE_Final_Test.Ex2.service.EmployeeService;
import DangTieuMinh_JavaSE_Final_Test.Ex2.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        boolean isRunning= true;

        Dao<Employee> employeeDao= new EmployeeDaoImpl();
        EmployeeService employeeService= new EmployeeServiceImpl(employeeDao);
        do {

            showMenu();
            Scanner scanner= new Scanner(System.in);
            System.out.println("Your choice: ");
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    handleEx(() -> create(scanner,employeeService));
                    break;
                case 2:
                    handleEx(() -> display(employeeService));
                    break;
                case 3:
                    handleEx(() -> remove(scanner,employeeService));
                    break;
                case 4:
                    isRunning= false;
                    break;
                default:
                    System.err.println("Invalid Input, please choice again!");
            }
        }while (isRunning);
    }
    public static void showMenu(){
        System.out.println("Choose function:");
        System.out.println("1. Add a new Employee");
        System.out.println("2. Show all employee");
        System.out.println("3. Remove customer");
        System.out.println("4. Exist");
    }
    public static void create(Scanner scanner, EmployeeService employeeService){
        Employee employee= new Employee();
        employeeService.createEmployee(scanner,employee);
    }
    public static void display(EmployeeService employeeService){
        List<Employee> employees= employeeService.findAll();
        employeeService.display(employees);
    }
    public static void remove(Scanner scanner, EmployeeService employeeService){
        System.out.println("REMOVE EMPLOYEE");
        System.out.println("Enter phone number: ");
        String phonetoRemove= scanner.nextLine();
        boolean removed= employeeService.removeEmployee(phonetoRemove);
        if (removed){
            System.out.println("Remove employee successful");
        }
        else {
            System.out.println("Not found employee by phone "+phonetoRemove);
        }
    }
    public static void handleEx(Runnable runnable){
        try {
            runnable.run();
        }catch (InvalidInputException e){
            System.err.println(e.getMessage());
        }
    }
}
