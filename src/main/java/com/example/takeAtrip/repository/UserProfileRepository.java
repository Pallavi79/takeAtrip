package com.example.takeAtrip.repository;
import com.example.takeAtrip.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    // Additional custom query methods can be defined here
    UserProfile findByUsername(String username);
}

