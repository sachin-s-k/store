package com.example.spring_store.repositories;

import com.example.spring_store.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {



}
