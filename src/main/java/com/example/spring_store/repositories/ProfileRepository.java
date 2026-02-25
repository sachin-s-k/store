package com.example.spring_store.repositories;

import com.example.spring_store.dtos.UserSummary;
import com.example.spring_store.models.Profile;
import com.example.spring_store.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @Query("SELECT p.id as id,p.user.email as email FROM Profile p WHERE p.loyaltyPoints > :loyaltyPoints")
    @EntityGraph(attributePaths =  "user")
    List<UserSummary> findLoyalProfiles(int loyaltyPoints);
}
