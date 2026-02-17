package com.example.spring_store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class OrderService {

    private PaymentService paymentService;



@Autowired
public OrderService(@Qualifier("paypal") PaymentService paymentService){

    System.out.println("order servie");
    this.paymentService=paymentService;

}
@PostConstruct
public void inti(){
    System.out.println("post constructor database calling");
}
@PreDestroy
public void  destroy(){
    System.out.println("pre destroy database calling=======>");
    }


    public void placeOrder(){
paymentService.processPayment(23.33);
    }
}
