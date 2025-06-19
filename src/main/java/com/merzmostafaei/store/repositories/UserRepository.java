package com.merzmostafaei.store.repositories;

import com.merzmostafaei.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
