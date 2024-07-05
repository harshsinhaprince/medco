package com.medicine.userService.service;

import com.medicine.userService.model.AuthenticationResponse;
import com.medicine.userService.model.Users;
import com.medicine.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        logger.info("Generated JWT Token: {}", token);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(Users user) {
        // Implement your authentication logic
        String token = jwtService.generateToken(user);
        logger.info("Generated JWT Token: {}", token);
        return new AuthenticationResponse(token);
    }
}
