package Lab10test.service.impl;

import Lab10test.model.Order;
import Lab10test.service.OrderService;
import Lab10test.utils.AppConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    public OrderServiceImpl() {
    }

    @Override
    public List<Order> createOrder(Scanner scanner) {
        List<Order> orders=new ArrayList<>();
        do {
           Order order= new Order();
            System.out.println("Enter order infor: ");
            System.out.println("+ Number: ");
            order.setNumber(scanner.nextLine());
            System.out.println("+ Date: ");
            order.setDate(scanner.nextLine());
            orders.add(order);
            System.out.println("countinue or finish (y/n)");
            String choice= scanner.nextLine();
            if (AppConstant.CHAR_FINISH.contains(choice)){
                break;
            }
        }while (true);
        return orders;
    }
}
