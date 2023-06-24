package com.example.UserManagement.controller;

import com.example.UserManagement.model.User;
import com.example.UserManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("users")
    String addUsers(@Valid @RequestBody List<User> users){
        return userService.createUsers(users);
    }

    @PostMapping("user")
    String addUser(@Valid @RequestBody  User user){
        return userService.createUser(user);
    }
}
