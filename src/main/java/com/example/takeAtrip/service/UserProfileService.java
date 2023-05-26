package com.example.takeAtrip.service;

import com.example.takeAtrip.dto.LoginRequest;
import com.example.takeAtrip.model.UserProfile;
import com.example.takeAtrip.repository.UserProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public void saveUserProfile(UserProfile userProfile) {
        UserProfile user =  new UserProfile();
        user.setUsername(userProfile.getUsername());
        user.setPassword(userProfile.getPassword());
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        user.setEmail(userProfile.getEmail());
        user.setPhoneNumber(userProfile.getPhoneNumber());

        userProfileRepository.save(user);

    }

    public boolean authenticate(String username, String password) {
        UserProfile user = userProfileRepository.findByUsername(username);
        if((user != null) && (password.equals(user.getPassword())))
            return true; // Authentication successful
        return false; // Authentication failed
    }
    public boolean login(LoginRequest loginRequest) {
        return authenticate(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
