/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-20
 * Modified: 2024-11-20
 * Description: Lab assignment
 */

package com.algonquin.cst8288.designPatterns;

// Template Abstract Class
abstract class OrderProcessTemplate {
    public final void processOrder() {
        selectItem();
        addAddress();
        if (isGift()) {
            wrapGift();
        }
        makePayment();
        deliverItem();
    }
    abstract void selectItem();
    abstract void addAddress();
    abstract void makePayment();
    abstract void deliverItem();
    // Hook method with a default implementation
    boolean isGift() {
        return false;
    }
    void wrapGift() {
        System.out.println("Item is wrapped as a gift.");
    }
}
// Concrete Subclass 1
class OnlineOrder extends OrderProcessTemplate {
    @Override
    void selectItem() {
        System.out.println("Item selected from online catalog.");
    }
    @Override
    void addAddress() {
        System.out.println("Address added for delivery.");
    }
    @Override
    void makePayment() {
        System.out.println("Payment done through Net Banking.");
    }
    @Override
    void deliverItem() {
        System.out.println("Item will be delivered to the given address.");
    }
}
// Concrete Subclass 2
class StoreOrder extends OrderProcessTemplate {
    @Override
    void selectItem() {
        System.out.println("Item selected from the store.");
    }
    @Override
    void addAddress() {
        System.out.println("Address unnecessary for in-store pickup.");
    }
    @Override
    void makePayment() {
        System.out.println("Bill paid at cash counter.");
    }
    @Override
    void deliverItem() {
        System.out.println("Item handed over at the counter.");
    }
    @Override
    boolean isGift() {
        return true; // Assume store order is a gift
    }
}
// Client
public class TestTemplatePattern {
    public static void main(String[] args) {
        OrderProcessTemplate onlineOrder = new OnlineOrder();
        OrderProcessTemplate storeOrder = new StoreOrder();
        System.out.println("Processing Online Order:");
        onlineOrder.processOrder();
        System.out.println("\nProcessing Store Order:");
        storeOrder.processOrder();
    }
}
