package com.bank.bank_management.service;

import com.bank.bank_management.model.Role;
import com.bank.bank_management.model.User;
import com.bank.bank_management.repository.RoleRepository;
import com.bank.bank_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Encrypt the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Check if the default role exists
        Role role = roleRepository.findByName("ROLE_USER").orElse(null);
        if (role == null) {
            // If not, create and persist it
            role = new Role();
            role.setName("ROLE_USER");
            role = roleRepository.save(role);
        }

        // Assign the role to the user
        user.setRoles(Collections.singleton(role));

        // Save the user
        return userRepository.save(user);
    }
}



