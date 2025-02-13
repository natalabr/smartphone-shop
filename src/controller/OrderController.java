package controller;

import persistence.Client;
import persistence.Order;
import repository.OrderRepository;

import java.util.List;

public class OrderController {

    private OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    public Order getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public void addNewOrder(Order order, Client client) {
        orderRepository.addNewOrder(order, client);
    }

    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteOrder(id);
    }
}
