package com.example.spring_store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Value("${payment-gateway:payal}")
    private String paymentGateway;
    @Bean
    public PaymentService stripe(){
        return new StripPaymentService();
    };
    @Bean
    public PaymentService paypal(){
        return new PaypalPaymenService();
    };

    @Bean
    public OrderService orderService(){
        if(paymentGateway.equals("stripe")){
            return   new OrderService(stripe());
        }else {
            return   new OrderService(paypal());

        }

    }
}
