/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-20
 * Modified: 2024-11-20
 * Description: Lab assignment
 */

package com.algonquin.cst8288.designPatterns;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card ending with " +
                cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal account " + email);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class TestStrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPaymentStrategy("1234567890123456"));
        cart.pay(100);

        cart.setPaymentStrategy(new PayPalPaymentStrategy("test@admin.com"));
        cart.pay(200);
    }
}
