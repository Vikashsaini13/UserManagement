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

    public User getAllUserById(Integer id) {
        List<User> originalList=getAllUsers();
        for(User user : originalList){
            if(user.getUserId().equals(id)){
                return user;
            }
        }

        return null;
    }

    public String deleteUserById(Integer id) {
        List<User> originalList=getAllUsers();
        for(User user : originalList){
            if(user.getUserId().equals(id)){
                originalList.remove(user);
                return "user removed successfully";
            }
        }
        return "user not found";
    }

    public String updateUserInfo(Integer id, String name, String pNo) {
        List<User> originalList=getAllUsers();
        for(User user : originalList){
            if(user.getUserId().equals(id)){
                user.setUserName(name);
                user.setUserContact(pNo);
                return "user Info updated successfully";
            }
        }
        return "user not found";
    }
}
