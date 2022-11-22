package com.example.demoJWTApplication.controller;

import com.example.demoJWTApplication.domain.User;
import com.example.demoJWTApplication.exception.UserNotFoundException;
import com.example.demoJWTApplication.service.SecurityTokenGenerate;
import com.example.demoJWTApplication.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
private UserService userService;

private SecurityTokenGenerate securityTokenGenerator;
@Autowired
public UserController(UserService userService,SecurityTokenGenerate securityTokenGenerate){
    this.userService = userService;
    this.securityTokenGenerator = securityTokenGenerate;
}
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map= null;

        try
        {
           User user1= userService.findByEmailAndPassword(user.getEmail(),user.getPassword());
            if(user1.getEmail().equals(user.getEmail()))
            {
                map= securityTokenGenerator.generateToken(user);

            }

            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
        catch (Exception se)
        {
            se.printStackTrace();
            return new ResponseEntity<>("Other exception", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
       User createUser = userService.addUser(user);
        return new ResponseEntity(createUser, HttpStatus.CREATED);
    }

}
