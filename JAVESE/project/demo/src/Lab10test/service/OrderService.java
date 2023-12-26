package Lab10test.service;

import Lab10test.model.Order;

import java.util.List;
import java.util.Scanner;

public interface OrderService {
    List<Order> createOrder(Scanner scanner);
}
