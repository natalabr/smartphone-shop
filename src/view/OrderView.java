package view;

import controller.OrderController;
import main.Main;
import persistence.Order;
import persistence.OrderItem;

import java.util.List;
import java.util.Scanner;

public class OrderView {

    OrderController orderController = new OrderController();

    public void orderMenu() {

        boolean orderMenu = true;
        do {

            System.out.println("-------Order Administration Menu-------");
            System.out.println("[1] Show Orders");
            System.out.println("[2] Show Orders by Customer");
            System.out.println("[3] Add Order");
            System.out.println("[4] Cancel Order");
            System.out.println("[9] Go back to Main Menu");

            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter the number of an Action: ");

            int userInput = myScanner.nextInt();

            switch (userInput) {
                case 1 -> getOrders();
                case 2 -> getOrdersByClient(myScanner);
                case 3 -> addOrder(myScanner);
                case 4 -> cancelOrder(myScanner);
                case 9 -> orderMenu = backToMainMenu();
            }
        }
        while (orderMenu);
    }

    private static boolean backToMainMenu() {

        boolean smartphoneMenu;
        Main.instance.displayMainMenu();
        smartphoneMenu = false;
        return smartphoneMenu;
    }

    private void getOrders() {

        List<Order> orders = orderController.getOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private void getOrdersByClient(Scanner myScanner) {

        System.out.println("Enter Client id: ");
        String clientId = myScanner.next();
        List<Order> orders = orderController.getOrders(clientId);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private void addOrder(Scanner myScanner) {

        Order newOrder = new Order();
        newOrder.active = true;
        System.out.println("Enter Client id: ");
        newOrder.clientId = myScanner.next();

        boolean keepAddingOrderItems = true;
        do {
            OrderItem orderItem = new OrderItem();
            System.out.println("Enter Smartphone id: ");
            orderItem.smartphoneId = myScanner.next();
            orderItem.unitPrice = orderController.getSmartphonePrice(orderItem.smartphoneId);
            if (orderItem.unitPrice <= 0) {
                System.out.println("Smartphone does not exist");
                continue;
            }
            System.out.println("Enter amount to add: ");
            orderItem.amount = myScanner.nextInt();

            newOrder.totalPrice += orderItem.amount * orderItem.unitPrice;
            newOrder.orderItems.add(orderItem);

            System.out.println("The Order Item was added. Do you want to add another one? Y/N");
            keepAddingOrderItems = myScanner.next().equalsIgnoreCase("y");

        } while (keepAddingOrderItems);

        orderController.addOrder(newOrder);
    }

    private void cancelOrder(Scanner myScanner) {

        System.out.println("Enter Order id: ");
        String orderId = myScanner.next();
        orderController.cancelOrder(orderId);

        if(!orderController.cancelOrder(orderId)) {
            System.out.println("Order does not exist");
        }
        System.out.println("Order cancelled");
    }
}
