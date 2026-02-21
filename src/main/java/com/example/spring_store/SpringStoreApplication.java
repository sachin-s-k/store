package com.example.spring_store;

import com.example.spring_store.models.Address;
import com.example.spring_store.models.Profile;
import com.example.spring_store.models.Tag;
import com.example.spring_store.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class SpringStoreApplication {

	public static void main(String[] args) {
ApplicationContext applicationContext=SpringApplication.run(SpringStoreApplication.class);


	}

}
