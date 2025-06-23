package com.merzmostafaei.store.repositories;

import com.merzmostafaei.store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//DTO (DataTransferObject)when use UserDto must map it to -> User Entity
//with JpaRepo -> findAll method return a list
//with Crudrepo -> findall method return Iterable
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
