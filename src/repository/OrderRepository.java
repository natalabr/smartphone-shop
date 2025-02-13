package repository;

import persistence.Client;
import persistence.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return null;
    }

    public Order getOrder(int id) {
        return null;
    }

    public void addNewOrder(Order order, Client client) {}

    public void updateOrder(Order order) {}

    public void deleteOrder(int id) {}
}
