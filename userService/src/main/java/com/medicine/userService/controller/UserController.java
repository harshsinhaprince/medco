package com.medicine.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.userService.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {


    @GetMapping("/loginSuccess")
    public String loginSuccess(Authentication authentication) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Map<String, Object> userDetails = oAuth2User.getAttributes();
        return "Welcome, " + userDetails.get("name");
    }

    @GetMapping("/user")
    public Map<String, Object> user(Authentication authentication) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        return oAuth2User.getAttributes();
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "Login failed!";
    }

    @GetMapping("/private")
    public ResponseEntity<String> privateEndpoint() {
        return ResponseEntity.ok("You accessed a private endpoint!");
    }
}
