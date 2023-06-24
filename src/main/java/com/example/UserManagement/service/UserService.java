package com.example.UserManagement.service;

import com.example.UserManagement.model.User;
import com.example.UserManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.getUsers();
    }

    public String createUsers(List<User> users) {
        List<User> originalList=getAllUsers();
        originalList.addAll(users);

        return "new users added successfully";
    }

    public String createUser(User user) {
        List<User> originalList=getAllUsers();
        originalList.add(user);

        return "new user added successfully";

    }
}
