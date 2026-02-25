package com.example.spring_store.repositories;

import com.example.spring_store.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> findProductsCriteria(String name, BigDecimal min, BigDecimal max);
}
