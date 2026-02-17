package com.example.spring_store;

public class StripPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount){

        System.out.println("STRIPE--->Payment successful"+ amount);

    }

}
