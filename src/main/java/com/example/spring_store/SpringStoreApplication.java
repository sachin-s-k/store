package com.example.spring_store;

import com.example.spring_store.models.Address;
import com.example.spring_store.models.Profile;
import com.example.spring_store.models.Tag;
import com.example.spring_store.models.User;
import com.example.spring_store.repositories.UserRepository;
import com.example.spring_store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class SpringStoreApplication {

	public static void main(String[] args) {
ApplicationContext applicationContext=SpringApplication.run(SpringStoreApplication.class);
var service=applicationContext.getBean(UserService.class);

service.fetchPaginatedProducts(0,2);


	}

}
