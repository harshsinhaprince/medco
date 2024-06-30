package com.medicine.userService.repository;

import com.medicine.userService.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
}
