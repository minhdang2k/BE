package Lab10test.service.impl;

import Lab10test.dao.CustomerDao;
import Lab10test.exception.InvalidInputException;
import Lab10test.model.Customer;
import Lab10test.model.Order;
import Lab10test.service.CustomerService;
import Lab10test.service.OrderService;
import Lab10test.utils.AppConstant;
import Lab10test.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private OrderService orderService;
    private CustomerDao<Customer> customerDao;
    private final List<Customer> customers= new ArrayList<>();

    public CustomerServiceImpl(OrderService orderService, CustomerDao<Customer> customerDao) {
        this.orderService = orderService;
        this.customerDao = customerDao;
    }
    // create findall search remove

    @Override
    public void create(Scanner scanner, Customer customer) {
        System.out.println("Enter customer information ");
        System.out.println("Enter name: ");
        customer.setName(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Enter phone: ");
        String phone= scanner.nextLine();
        if (!Validator.isPhone(phone)){
            throw new InvalidInputException("Invalid phone");
        }
        else {
            customer.setPhoneNumber(phone);
        }
        System.out.println("Enter Address: ");
        customer.setAddress(scanner.nextLine());
        List<Order> orders= orderService.createOrder(scanner);
        customers.add(customer);
        customerDao.insert(customer);
    }
    public List<Customer> findAll(){
        return  customers;
    }

    @Override
    public void display(List<Customer> customers) {
        System.out.println("List customer");
        System.out.println(customers);
    }
    public List<Customer> search(String phone){
        List<Customer> customerFind= new ArrayList<>();
        for (Customer customer: customers){
            if (customer.getPhoneNumber().equals(phone)){
                customerFind.add(customer);
            }
        }
        return customers;
    }

    @Override
    public boolean remove(String phone) {
        return customers.removeIf(customer -> customer.getPhoneNumber().equals(phone));
    }
}
