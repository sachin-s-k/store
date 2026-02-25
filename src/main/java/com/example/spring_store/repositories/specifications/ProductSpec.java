package com.example.spring_store.repositories.specifications;

import com.example.spring_store.models.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpec {
    public static Specification<Product> hasName(String name){
     return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
    public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal min){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), min);
    }
    public static Specification<Product> hasPriceLessThanOrEqualTo(BigDecimal max){
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), max);
    }
}
