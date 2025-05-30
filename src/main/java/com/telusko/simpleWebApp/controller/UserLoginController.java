package com.telusko.simpleWebApp.controller;

import com.telusko.simpleWebApp.dto.UsersDto;
import com.telusko.simpleWebApp.entity.Users;
import com.telusko.simpleWebApp.service.UserService;
import com.telusko.simpleWebApp.serviceImpl.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class UserLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto)
    {
        return new ResponseEntity<>(userService.addUser(usersDto), HttpStatus.CREATED);
    }

  /*  @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users users)
    {
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(users.getName(),users.getPassword());
        Authentication authentication=authenticationManager.authenticate(token);
        boolean status =authentication.isAuthenticated();

        if(status)
        {
            return new ResponseEntity<>("Welcome",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
        }
    }*/
    @PostMapping("/login")
    public String verify(@RequestBody Users users)
    {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getName(),users.getPassword(), Collections.emptyList()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(users.getName());
        }
        return "fail";
    }
}
