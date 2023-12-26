package ls10.lab;

import ls10.lab.dao.Dao;
import ls10.lab.dao.impl.CustomerDaoImpl;
import ls10.lab.exception.InvalidInputException;
import ls10.lab.model.Customer;
import ls10.lab.service.CustomerService;
import ls10.lab.service.OrderService;
import ls10.lab.service.impl.CustomerServiceImpl;
import ls10.lab.service.impl.OrderServiceImpl;

import java.util.List;
import java.util.Scanner;

public class SaleManagement {
    public static void main(String[] args) {
        boolean isRunning = true;

        // khoi tao cac service
        OrderService orderService = new OrderServiceImpl();
        Dao<Customer> customerDao = new CustomerDaoImpl();
        CustomerService customerService = new CustomerServiceImpl(orderService, customerDao);

        do {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleEx(() -> create(scanner, customerService));
                    break;
                case 2:
                    handleEx(() -> display(customerService));
                    break;
                case 3:
                    handleEx(() -> search(scanner, customerService));
                    break;
                case 4:
                    handleEx(() -> remove(scanner, customerService));
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.err.println("Invalid input. Please try again");
            }
        } while (isRunning);
    }

    public static void showMenu() {
        System.out.println("Choose function:");
        System.out.println("1. Add a new Customer");
        System.out.println("2. Show all customers");
        System.out.println("3. Search customer");
        System.out.println("4. Remove customer");
        System.out.println("5. Exist");
    }

    public static void create(Scanner scanner, CustomerService customerService) {
        Customer customer = new Customer();
        customerService.createCustomer(scanner, customer);
    }

    public static void display(CustomerService customerService) {
        List<Customer> customers = customerService.findAll();
        customerService.display(customers);
    }

    public static void search(Scanner scanner, CustomerService customerService) {
        System.out.println("---------SEARCH CUSTOMER-----------");
        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();
        List<Customer> customers = customerService.search(phone);
        customerService.display(customers);
    }

    public static void remove(Scanner scanner, CustomerService customerService) {
        System.out.println("---------REMOVE CUSTOMER---------");
        System.out.println("Enter phone number:");
        String phoneToRemove = scanner.nextLine();
        boolean removed = customerService.remove(phoneToRemove);
        if (removed) {
            System.out.println("Remove customer successful");
        } else {
            System.out.println("Not found customer by phone " + phoneToRemove);
        }
    }

    // Java khong co callback
    public static void handleEx(Runnable runnable) {
        try {
            runnable.run();
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());
        }
    }
}
