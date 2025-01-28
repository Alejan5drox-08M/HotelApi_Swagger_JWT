package com.example.hotel_api_adgm.services;

import com.example.hotel_api_adgm.models.User;
import com.example.hotel_api_adgm.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> findUser(String name, String password) {
        return userRepository.findUser(name, password);
    }
}
