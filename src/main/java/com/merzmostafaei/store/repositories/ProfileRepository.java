package com.merzmostafaei.store.repositories;

import com.merzmostafaei.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}