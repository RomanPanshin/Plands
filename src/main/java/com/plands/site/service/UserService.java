package com.plands.site.service;

import com.plands.site.model.User;
import com.plands.site.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new user
    public User registerUser(String email, String nickname, String rawPassword) {
        User user = new User();
        Timestamp now = new Timestamp(System.currentTimeMillis());

        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setCreationDate(now);
        user.setLastSeen(now);

        return userRepository.save(user);
    }

    // Find a user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
