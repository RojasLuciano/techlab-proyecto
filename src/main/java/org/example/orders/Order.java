package org.example.orders;

import org.example.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;
    private int id;
    private List<OrderItem> items;

    public Order() {
        this.id = counter++;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addItem(Product product, int quantity) {
        this.items.add(new OrderItem(product, quantity));
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void confirmOrder() {
        for (OrderItem item : items) {
            item.getProduct().decreaseStock(item.getQuantity());
        }
    }

    public void showDetails() {
        System.out.println("Order #" + id);
        for (OrderItem item : items) {
            item.showDetail();
        }
        System.out.println("Total: $" + getTotal());
    }
}
