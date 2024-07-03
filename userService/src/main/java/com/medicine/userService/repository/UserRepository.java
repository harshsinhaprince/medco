package com.medicine.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.userService.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
