package persistence;

import java.time.LocalDate;

public class Order {

    public int orderNumber;
    public LocalDate orderDate;
    public double totalPrice;

    public Order(Client client) {}
}
