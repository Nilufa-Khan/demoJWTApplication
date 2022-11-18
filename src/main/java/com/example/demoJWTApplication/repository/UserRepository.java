package com.example.demoJWTApplication.repository;

import com.example.demoJWTApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    public User findByEmailAndPassword(String email, String password);
}
