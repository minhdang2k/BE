package ls10.lab.service.impl;

import ls10.lab.dao.Dao;
import ls10.lab.exception.InvalidInputException;
import ls10.lab.model.Customer;
import ls10.lab.model.Order;
import ls10.lab.service.CustomerService;
import ls10.lab.service.OrderService;
import ls10.lab.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private OrderService orderService;
    private Dao<Customer> customerDao;
    private final List<Customer> customers = new ArrayList<>();

    public CustomerServiceImpl(OrderService orderService,
                               Dao<Customer> customerDao) {
        this.orderService = orderService;
        this.customerDao = customerDao;
    }

    @Override
    public void createCustomer(Scanner scanner, Customer customer) {
        // nhap cac thong tin cua customer
        System.out.println("-----Enter customer information---");
        System.out.println("Enter name:");
        customer.setName(scanner.nextLine());

        System.out.println("Enter phone:");
        String phone = scanner.nextLine();
        if (!Validator.isPhone(phone)) {
            throw new InvalidInputException("Invalid phone number");
        }
        customer.setPhoneNumber(phone);

        System.out.println("Enter address:");
        customer.setAddress(scanner.nextLine());

        // create orders
        List<Order> orders = orderService.createOrder(scanner);
        customer.setOrders(orders);
        customers.add(customer);
        customerDao.insert(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public void display(List<Customer> customers) {
        System.out.println("------LIST OF CUSTOMER---------");
        System.out.println(customers);
    }

    @Override
    public List<Customer> search(String phone) {
//        List<Customer> customersFind = new ArrayList<>();
//
//        for (Customer customer : customers) {
//            if (customer.getPhoneNumber().equals(phone)) {
//                customersFind.add(customer);
//            }
//        }
//        return customersFind;
        // Streams API JAVA 8
        return customers
                .stream()
                .filter(customer -> customer.getPhoneNumber().equals(phone.trim()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean remove(String phone) {
        return customers.removeIf(customer -> customer.getPhoneNumber().equals(phone));
    }
}
