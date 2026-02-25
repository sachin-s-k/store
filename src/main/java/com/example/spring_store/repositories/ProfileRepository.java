package com.example.spring_store.repositories;

import com.example.spring_store.models.Profile;
import com.example.spring_store.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
