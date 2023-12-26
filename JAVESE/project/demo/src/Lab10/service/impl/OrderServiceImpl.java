package ls10.lab.service.impl;

import ls10.lab.model.Order;
import ls10.lab.service.OrderService;
import ls10.lab.util.AppConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> createOrder(Scanner scanner) {
        List<Order> orders = new ArrayList<>();

        do {
            Order order = new Order();

            System.out.println("Enter order info:");
            System.out.print("+ Number: ");
            String numberOrder = scanner.nextLine();
            order.setNumber(numberOrder);
            // validate

            System.out.print("+ Date: ");
            String orderDate = scanner.nextLine();
            order.setDate(orderDate);
            // validate

            orders.add(order);
            System.out.println("continue or finish (y/n)");
            String choice = scanner.nextLine();
            if (AppConstant.CHAR_FINISH.contains(choice)) {
                break;
            }
        } while (true);

        return orders;
    }

}
