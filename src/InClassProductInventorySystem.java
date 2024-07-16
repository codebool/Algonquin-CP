/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-16
 * Modified: 2024-07-16
 * Description: Lab assignment
 */

import java.util.*;

// Define the ProductInventorySystem class to manage the inventory of products
public class InClassProductInventorySystem {
    // Use a HashMap to store products, with the product ID as the key and the Product object as the value
    private Map<Integer, Product> products = new HashMap<>();

    // Method to add a new product to the inventory
    public void addProduct(Product product) {
        products.put(product.getId(), product); // Add the product to the HashMap
    }

    // Method to remove an existing product from the inventory by its ID
    public void removeProduct(int id) {
        products.remove(id); // Remove the product from the HashMap
    }

    // Method to update the details of an existing product by its ID
    public void updateProduct(int id, String name, double price, int quantity) {
        // Retrieve the product object from the HashMap
        Product product = products.get(id);
        if (product != null) { // Check if the product exists
            // Update the product's details
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
        }
    }

    // Method to list all products sorted by their price
    public void listProductsSortedByPrice() {
        // Use a TreeMap to sort products by their price
        TreeMap<Double, Product> sortedProducts = new TreeMap<>();
        // Iterate over each product in the HashMap and add them to the TreeMap
        for (Product product : products.values()) {
            sortedProducts.put(product.getPrice(), product);
        }
        // Print each product in the sorted order by price
        sortedProducts.values().forEach(System.out::println);
    }

    // Main method to interact with the ProductInventorySystem
    public static void main(String[] args) {
        // Create an instance of ProductInventorySystem
        InClassProductInventorySystem pis = new InClassProductInventorySystem();

        // Add products to the inventory
        pis.addProduct(new Product(1, "Laptop", 999.99, 10));
        pis.addProduct(new Product(2, "Smartphone", 499.99, 20));
        pis.addProduct(new Product(3, "Tablet", 299.99, 15));

        // List all products sorted by price
        System.out.println("Listing Products:");
        pis.listProductsSortedByPrice();

        // Update a product's details
        pis.updateProduct(2, "Smartphone", 450.99, 25);

        // Remove a product from the inventory
        pis.removeProduct(3);

        // List all products again after update and removal
        System.out.println("\nListing Products after updates:");
        pis.listProductsSortedByPrice();
    }
}
