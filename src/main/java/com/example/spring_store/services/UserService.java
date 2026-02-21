package com.example.spring_store.services;

import com.example.spring_store.models.User;
import com.example.spring_store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;

@Transactional
    public void showEntity(){
        var user= User.builder().name("sachin").email("emai@s.com").password("password").build();
        if(entityManager.contains(user)){
            System.out.println("persistent");
        }else{
            System.out.println("transinet/ detached");
        }
        userRepository.save(user);
        if(entityManager.contains(user)){
            System.out.println("persistent");
        }else{
            System.out.println("transinet/ detached");
        }
    }
}
