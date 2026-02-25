package com.example.spring_store.repositories;

import com.example.spring_store.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@AllArgsConstructor
@Repository
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Product> findProductsCriteria(String name, BigDecimal min, BigDecimal max) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = cb.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        List<Predicate> predicateList = new ArrayList<>();
        if (name != null) {
            predicateList.add(
                    cb.like(root.get("name"), "%" + name + "%")
            );
        }
        if (min != null) {
            predicateList.add(
                    cb.greaterThanOrEqualTo(root.get("price"), min)
            );
        }




if(max!=null){
        predicateList.add(
                cb.lessThanOrEqualTo(root.get("price"),max)
        );}

        criteriaQuery.select(root).where(predicateList.toArray(new Predicate[predicateList.size()]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
