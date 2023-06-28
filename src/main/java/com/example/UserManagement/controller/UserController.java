package com.example.UserManagement.controller;

import com.example.UserManagement.model.User;
import com.example.UserManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //get all users
    @GetMapping("users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //get user by particular id
    @GetMapping("users/{id}")
     public User getAllUserById(@PathVariable Integer id){

        return userService.getAllUserById(id);
    }

    //add multiple users at a time
    @PostMapping("users")
    String addUsers(@Valid @RequestBody List<User> users){
        return userService.createUsers(users);
    }


    //add sigle user
    @PostMapping("user")
    String addUser(@Valid @RequestBody  User user){
        return userService.createUser(user);
    }

    //delete user by id
    @DeleteMapping("users/{id}")
    public String deleteUserById(@PathVariable Integer id){

        return userService.deleteUserById(id);
    }

    //updating name and contact number of a particular user based on userId
    @PutMapping("users/{id}/{name}/{pNo}")
    public String updateUserInfo(@PathVariable Integer id,@PathVariable String name,@PathVariable String pNo){
        return userService.updateUserInfo(id,name,pNo);
    }
}
