package com.example.demoJWTApplication.service;

import com.example.demoJWTApplication.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGenerator implements SecurityTokenGenerate{

    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = null;

        jwtToken = Jwts.builder().setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"examplekey").compact();
        Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User Successfully logged in");
        return map;
    }
}
