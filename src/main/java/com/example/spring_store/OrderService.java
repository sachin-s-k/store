package com.example.spring_store;

public class OrderService {

    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    public void placeOrder(){
paymentService.processPayment(23.33);
    }
}
