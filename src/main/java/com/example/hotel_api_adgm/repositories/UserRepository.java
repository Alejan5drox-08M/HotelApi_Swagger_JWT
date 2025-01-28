package com.example.hotel_api_adgm.repositories;

import com.example.hotel_api_adgm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username = :name AND u.password = :password")
    Optional<User> findUser(String name, String password
    );
}
