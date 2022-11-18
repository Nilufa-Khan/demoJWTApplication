package com.example.demoJWTApplication.service;

import com.example.demoJWTApplication.domain.User;

import java.util.Map;

public interface SecurityTokenGenerate {
    Map<String,String> generateToken(User user);
}
