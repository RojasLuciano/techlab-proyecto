package org.example;
import org.example.exceptions.InsufficientStockException;
import org.example.services.ProductService;
import org.example.services.OrderService;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService(productService);

        while (true) {
            System.out.println("\n===== PRODUCT & ORDER MANAGEMENT =====");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Start New Order");
            System.out.println("6. Add Item to Current Order");
            System.out.println("7. Confirm Current Order");
            System.out.println("8. List Confirmed Orders");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());
            try {
                switch (option) {
                    case 1:
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Stock: ");
                        int stock = Integer.parseInt(scanner.nextLine());
                        productService.addProduct(name, price, stock);
                        break;
                    case 2:
                        productService.listProducts();
                        break;
                    case 3:
                        System.out.print("Product ID to update: ");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        System.out.print("New Price: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        System.out.print("New Stock: ");
                        int newStock = Integer.parseInt(scanner.nextLine());
                        productService.updateProduct(updateId, newPrice, newStock);
                        break;
                    case 4:
                        System.out.print("Product ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        productService.deleteProduct(deleteId);
                        break;
                    case 5:
                        orderService.startNewOrder();
                        break;
                    case 6:
                        System.out.print("Product ID: ");
                        int pid = Integer.parseInt(scanner.nextLine());
                        System.out.print("Quantity: ");
                        int qty = Integer.parseInt(scanner.nextLine());
                        orderService.addItem(pid, qty);
                        break;
                    case 7:
                        orderService.confirmOrder();
                        break;
                    case 8:
                        orderService.listOrders();
                        break;
                    case 9:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (InsufficientStockException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}