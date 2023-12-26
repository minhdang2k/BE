package ls10.lab.service;

import ls10.lab.model.Order;

import java.util.List;
import java.util.Scanner;

public interface OrderService {
    List<Order> createOrder(Scanner scanner);
}
