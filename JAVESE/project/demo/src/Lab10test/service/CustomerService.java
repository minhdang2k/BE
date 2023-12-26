package Lab10test.service;

import Lab10test.model.Customer;

import java.util.List;
import java.util.Scanner;

public interface CustomerService {
    // create findall display search remove
    void create(Scanner scanner, Customer customer);
    List<Customer> findAll();
    void display(List<Customer> customers);
    List<Customer> search(String phone);
    boolean remove(String phone);
}
