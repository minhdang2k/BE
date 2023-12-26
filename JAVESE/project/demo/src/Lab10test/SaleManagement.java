package Lab10test;

import Lab10test.dao.CustomerDao;
import Lab10test.dao.DaoImpl.CustomerDaoImpl;
import Lab10test.exception.InvalidInputException;
import Lab10test.model.Customer;
import Lab10test.service.CustomerService;
import Lab10test.service.OrderService;
import Lab10test.service.impl.CustomerServiceImpl;
import Lab10test.service.impl.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleManagement {
    public static void main(String[] args) {
        boolean isRunning= true;
        OrderService orderService= new OrderServiceImpl();
        CustomerDao<Customer> customerDao = new CustomerDaoImpl();
        CustomerService customerService= new CustomerServiceImpl(orderService,customerDao);
        do{
            Scanner scanner=new Scanner(System.in);
            showMenu();
            System.out.println("Your choice: ");
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    handleEx(() -> createCustomer(scanner,customerService));
                    break;
                case 2:
                    handleEx(() -> showAll(customerService));
                    break;
                case 3:
                    handleEx(() -> searchCustomer(scanner,customerService));
                    break;
                case 4:
                    handleEx(() -> removeCustomer(scanner,customerService));
                    break;
                case 5:
                    isRunning=false;
                    break;
            }
        }while (isRunning);
    }
    public static void showMenu(){
        System.out.println("Choose function:");
        System.out.println("1. Add a new Customer");
        System.out.println("2. Show all customers");
        System.out.println("3. Search customer");
        System.out.println("4. Remove customer");
        System.out.println("5. Exist");
    }
    public static void createCustomer(Scanner scanner, CustomerService customerService){
        Customer customer= new Customer();
        customerService.create(scanner,customer);
    }
    public static void showAll( CustomerService customerService){
        List<Customer> customers= customerService.findAll();
        customerService.display(customers);
    }
    public static void searchCustomer(Scanner scanner, CustomerService customerService){
        System.out.println("Search Customer");
        System.out.println("Enter phone: ");
        String phone= scanner.nextLine();
        List<Customer> customers= customerService.search(phone);
        customerService.display(customers);
    }
    public static void removeCustomer(Scanner scanner, CustomerService customerService){
        System.out.println("Remove Customer");
        System.out.println("Enter phone:");
        String phonetoRemove= scanner.nextLine();
        boolean removed=customerService.remove(phonetoRemove);
        if (removed){
            System.out.println("Remove customer successful");
        }
        else {
            System.out.println("Not found customer by phone"+phonetoRemove);
        }
    }
    public static void handleEx(Runnable runnable){
        try {
            runnable.run();
        }catch (InvalidInputException e){
            System.err.printf(e.getMessage());
        }
    }
}
