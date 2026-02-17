package com.example.spring_store;

public class PaypalPaymenService implements  PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Payment Service");
        System.out.println("amount---->"+amount);
    }
}
