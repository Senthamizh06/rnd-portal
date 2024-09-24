package com.project.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.project.proj.model.User;
import com.project.proj.repository.UserInfoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    // Create a new user with proper error handling
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            User savedUser = userInfoRepository.save(newUser);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create user", e);
        }
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userInfoRepository.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to fetch users", e);
        }
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return userInfoRepository.findById(id)
            .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        return userInfoRepository.findById(id)
            .map(user -> {
                userInfoRepository.delete(user);
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    // Update user details
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable String id, @RequestBody User updatedUser) {
        return userInfoRepository.findById(id)
            .map(existingUser -> {
                // Update fields
                existingUser.setUsername(updatedUser.getUsername());
                existingUser.setDesignation(updatedUser.getDesignation());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setContactNumber(updatedUser.getContactNumber());
                existingUser.setPhoto(updatedUser.getPhoto());
                existingUser.setSpecialization(updatedUser.getSpecialization());
                existingUser.setDepartment(updatedUser.getDepartment());

                User savedUser = userInfoRepository.save(existingUser);
                return new ResponseEntity<>(savedUser, HttpStatus.OK);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
