package com.merzmostafaei.store.repositories;

import com.merzmostafaei.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}