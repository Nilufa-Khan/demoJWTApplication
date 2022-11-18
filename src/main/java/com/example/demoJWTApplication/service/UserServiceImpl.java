package com.example.demoJWTApplication.service;

import com.example.demoJWTApplication.domain.User;
import com.example.demoJWTApplication.exception.UserNotFoundException;
import com.example.demoJWTApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
        private UserRepository userRepository;

        @Autowired
        public UserServiceImpl(UserRepository userRepository){
            this.userRepository = userRepository;
        }
            @Override
            public User addUser(User user) {
                return userRepository.save(user);
            }

            @Override
            public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {

               User user =userRepository.findByEmailAndPassword(email,password);
                if(user == null){
                    throw new UserNotFoundException();
                }
                return user;
            }


}
