package com.example.spring_store.repositories;

import com.example.spring_store.dtos.ProductSummary;
import com.example.spring_store.dtos.ProductSummaryDto;
import com.example.spring_store.models.Category;
import com.example.spring_store.models.Product;
import com.example.spring_store.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> ,ProductCriteriaRepository, JpaSpecificationExecutor<Product> {
// find products whose prices are in a given range sort by name
    // as an argument we can prodvide sql or jpql java persistence query lanaguage
     @Procedure("findProductsByPrice")
     List<Product> findProducts(  BigDecimal min,BigDecimal max);
//
//     //
//     @Query( "select p from Product p where p.price between: min and :max order by p.name")
//     List<Product> findProducts(@Param("min") BigDecimal min,@Param("max") BigDecimal max){
//
//     }
//      @Query("select count(*) from Product P  where P.price between :min and :max")
//     long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max){}
//     @Modifying
//     @Query("update product p set p.price=: newPrice where p.category.id=:categoryId")
//     void updatePriceByCategory(BigDecimal newPrice, Byte categoryId){
    @Query("select new com.example.spring_store.dtos.ProductSummaryDto(p.id, p.name)  from Product p where p.category=:category")
     List<ProductSummaryDto> findByCategory(@Param("category") Category category);
}
