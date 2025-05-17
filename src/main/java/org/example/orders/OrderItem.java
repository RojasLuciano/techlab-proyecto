package org.example.orders;

import org.example.products.Product;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public void showDetail() {
        System.out.println(quantity + " x " + product.getName() + " = $" + getSubtotal());
    }
}