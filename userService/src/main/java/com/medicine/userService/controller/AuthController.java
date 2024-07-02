package com.medicine.userService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.userService.model.AuthenticationResponse;
import com.medicine.userService.model.Users;
import com.medicine.userService.service.AuthenticationService;

@RestController
public class AuthController {
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Users request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Users request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
