package com.example.spring_store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public class StripPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount){

        System.out.println("STRIPE--->Payment successful"+ amount);

    }

}
