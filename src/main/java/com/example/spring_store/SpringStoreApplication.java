package com.example.spring_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringStoreApplication {

	public static void main(String[] args) {
ApplicationContext applicationContext= SpringApplication.run(SpringStoreApplication.class, args);



	}

}
