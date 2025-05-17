package org.example.services;

import org.example.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(String name, double price, int stock) {
        Product product = new Product(name, price, stock);
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product p : products) {
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Price: $" + p.getPrice() + ", Stock: " + p.getStock());
        }
    }

    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean updateProduct(int id, double newPrice, int newStock) {
        Product p = findById(id);
        if (p != null) {
            p.setPrice(newPrice);
            p.setStock(newStock);
            System.out.println("Product updated.");
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        Product p = findById(id);
        if (p != null) {
            products.remove(p);
            System.out.println("Product removed.");
            return true;
        }
        return false;
    }

    public List<Product> getAll() {
        return products;
    }
}