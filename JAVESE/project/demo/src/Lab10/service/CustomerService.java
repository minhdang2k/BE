package ls10.lab.service;

import ls10.lab.model.Customer;

import java.util.List;
import java.util.Scanner;

public interface CustomerService {
    void createCustomer(Scanner scanner, Customer customer);
    List<Customer> findAll();

    void display(List<Customer> customers);

    List<Customer> search(String phone);

    boolean remove(String phone);
}
