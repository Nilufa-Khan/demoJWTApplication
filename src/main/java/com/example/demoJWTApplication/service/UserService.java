package com.example.demoJWTApplication.service;

import com.example.demoJWTApplication.domain.User;
import com.example.demoJWTApplication.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public User findByEmailAndPassword(String email, String password) throws UserNotFoundException;

}
