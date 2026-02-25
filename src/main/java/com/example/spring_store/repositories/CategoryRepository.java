package com.example.spring_store.repositories;

import com.example.spring_store.models.Category;
import com.example.spring_store.models.User;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
