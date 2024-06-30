package com.medicine.userService.service;

import java.util.List;
import java.util.Optional;

import com.medicine.userService.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.userService.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(Users users) {
        if (userRepository.existsByEmail(users.getEmail())) {
            return "Error: Email already in use!";
        }
        userRepository.save(users);
        return "User registered successfully!";
    }

    public List<Users> listAll() {
        return userRepository.findAll();
    }

    public Optional<Users> get(Long id) {
        return userRepository.findById(id);
    }

}
