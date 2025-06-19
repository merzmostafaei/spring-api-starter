package com.merzmostafaei.store.repositories;

import com.merzmostafaei.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}