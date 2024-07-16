/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-16
 * Modified: 2024-07-16
 * Description: Lab assignment
 */

import java.util.*;

public class ProductInventorySystem {
    private Map<Integer, Product> products = new HashMap<>();

    private Set<Integer> soldOutProducts = new HashSet<>();

    public void importProduct(Product product) {
        if (products.containsKey(product.getId())) {
            updateProduct(product.getId(), product.getName(), product.getPrice(), product.getQuantity());
        } else {
            products.put(product.getId(), product);
        }
    }

    public void sellProduct(int productId, int quantity) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                if (product.getQuantity() == 0) {
                    soldOutProducts.add(productId);
                }
            } else {
                System.out.println("Not enough quantity!");
            }
        } else {
            System.out.println("Product not found!");
        }
    }

    public void updateProduct(int productId, String name, double price, int quantity) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void listAvailableProducts() {
        for (int productId : products.keySet()) {
            if (!soldOutProducts.contains(productId)) {
                System.out.println(products.get(productId));
            }
        }
    }

    public static void main(String[] args) {
        ProductInventorySystem pis = new ProductInventorySystem();

        pis.importProduct(new Product(1, "Java Programming", 49.99, 10));
        pis.importProduct(new Product(2, "Python Programming", 39.99, 20));
        pis.importProduct(new Product(3, "Ruby Programming", 29.99, 30));
        pis.importProduct(new Product(4, "C Programming", 19.99, 40));
        pis.importProduct(new Product(5, "C++ Programming", 9.99, 50));
        System.out.println("Available products: ");
        pis.listAvailableProducts();

        pis.sellProduct(3, 5);
        pis.sellProduct(4, 10);
        pis.sellProduct(5, 15);
        System.out.println("\nAfter selling the available products: ");
        pis.listAvailableProducts();

        pis.updateProduct(1, "Java Programming", 59.99, 20);
        pis.updateProduct(2, "Python Programming", 49.99, 30);
        pis.updateProduct(3, "Ruby Programming", 39.99, 40);
        pis.updateProduct(4, "C Programming", 29.99, 50);
        pis.updateProduct(5, "C++ Programming", 19.99, 60);
        System.out.println("\nAfter updating the available products: ");
        pis.listAvailableProducts();
    }
}
