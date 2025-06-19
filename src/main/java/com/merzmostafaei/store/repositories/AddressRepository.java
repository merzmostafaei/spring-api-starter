package com.merzmostafaei.store.repositories;

import com.merzmostafaei.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}