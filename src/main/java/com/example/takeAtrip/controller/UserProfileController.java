package com.example.takeAtrip.controller;

import com.example.takeAtrip.dto.LoginRequest;
import com.example.takeAtrip.model.UserProfile;
import com.example.takeAtrip.service.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/userprofile")
@AllArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    @PostMapping("/signup")
    public ResponseEntity<String> createUserProfile(@RequestBody UserProfile userProfile) {
        userProfileService.saveUserProfile(userProfile);
        return new ResponseEntity<>("User Registration Successful", OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> signup(@RequestBody LoginRequest loginRequest) {
        userProfileService.login(loginRequest);
        return new ResponseEntity<>("User Login Successful",
                OK);
    }
}
