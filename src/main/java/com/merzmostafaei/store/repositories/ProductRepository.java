package com.merzmostafaei.store.repositories;

import com.merzmostafaei.store.entities.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//Building Product EndPoints
public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte categoryId);

    //3-Fetch Product to Category with custom query
    @EntityGraph(attributePaths = "category")
    //@Query("SELECT p FROM Product p JOIN FETCH p.category")-> use this or with EntityGraph
    @Query("SELECT p FROM Product p")
    List<Product> findAllWithCategory();

}