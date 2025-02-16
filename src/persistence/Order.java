package persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    public String id;
    public String clientId;
    public int orderNumber;
    public LocalDate orderDate;
    public double totalPrice;
    public boolean active;
    public ArrayList<OrderItem> orderItems = new ArrayList<>();

    public String toString() {
        return id + ": " + orderNumber + " " + orderDate + " " + active;
    }

}
