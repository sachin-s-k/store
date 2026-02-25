package com.example.spring_store.repositories;

import com.example.spring_store.models.Address;
import com.example.spring_store.models.Profile;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
