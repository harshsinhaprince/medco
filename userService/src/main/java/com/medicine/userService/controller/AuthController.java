package com.medicine.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.userService.model.AuthenticationResponse;
import com.medicine.userService.model.Users;
import com.medicine.userService.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Users request) {
        logger.info("Received registration request: {}", request);
        AuthenticationResponse response = authenticationService.register(request);
        logger.info("Registration response: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Users request) {
        logger.info("Received login request: {}", request);
        AuthenticationResponse response = authenticationService.authenticate(request);
        logger.info("Login response: {}", response);
        return ResponseEntity.ok(response);
    }
}
