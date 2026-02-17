package com.example.spring_store;

import org.springframework.stereotype.Service;

public class PaypalPaymenService implements  PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Payment Service");
        System.out.println("amount---->"+amount);
    }
}
