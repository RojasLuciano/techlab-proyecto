
package org.example.services;

import org.example.exceptions.InsufficientStockException;
import org.example.orders.Order;
import org.example.orders.OrderItem;
import org.example.products.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> confirmedOrders = new ArrayList<>();
    private Order currentOrder;
    private ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
        this.currentOrder = new Order();
    }

    public void startNewOrder() {
        currentOrder = new Order();
        System.out.println("New order started. ID: " + currentOrder.getId());
    }

    public void addItem(int productId, int quantity) {
        Product product = productService.findById(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }
        currentOrder.addItem(product, quantity);
        System.out.println("Product added to order.");
    }

    public void confirmOrder() throws InsufficientStockException {
        for (OrderItem item : currentOrder.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            if (product.getStock() < quantity) {
                throw new InsufficientStockException("Insufficient stock for product: " + product.getName());
            }
        }
        currentOrder.confirmOrder();
        confirmedOrders.add(currentOrder);
        System.out.println("Order confirmed. Total: $" + currentOrder.getTotal());
    }

    public void listOrders() {
        if (confirmedOrders.isEmpty()) {
            System.out.println("No confirmed orders.");
            return;
        }
        for (Order order : confirmedOrders) {
            order.showDetails();
            System.out.println("----------------------------");
        }
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
