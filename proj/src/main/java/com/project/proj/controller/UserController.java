package com.project.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.proj.model.Department1;
import com.project.proj.repository.UserRepository;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // private static final Logger logger =
    // LoggerFactory.getLogger(UserController.class);

    @PostMapping("/user")
    public Department1 newUser(@RequestBody Department1 newUser) {
        // Log the received Userr object

        return userRepository.save(newUser);
    }
}
