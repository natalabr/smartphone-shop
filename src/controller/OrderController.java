package controller;

import persistence.Client;
import persistence.Order;
import persistence.Smartphone;
import repository.ClientRepository;
import repository.OrderRepository;
import repository.SmartphoneRepository;

import java.util.List;

public class OrderController {

    private OrderRepository orderRepository = new OrderRepository();
    private SmartphoneRepository smartphoneRepository = new SmartphoneRepository();

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    public List<Order> getOrders(String id) {

        return orderRepository.getOrders(id);
    }

    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public double getSmartphonePrice(String smartphoneId) {
        Smartphone smartphone = smartphoneRepository.getSmartphone(smartphoneId);
        if (smartphone == null) {
            return 0;
        }
        return smartphone.unitPrice;
    }

    public boolean cancelOrder(String id) {

        return orderRepository.cancelOrder(id);
    }
}
