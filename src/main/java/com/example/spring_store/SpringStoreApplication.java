package com.example.spring_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStoreApplication.class, args);

		var orderService=new OrderService();
		orderService.setPaymentService(new PaypalPaymenService());
		orderService.placeOrder();
	}

}
