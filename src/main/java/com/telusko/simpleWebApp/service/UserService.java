package com.telusko.simpleWebApp.service;

import com.telusko.simpleWebApp.dto.UsersDto;
import com.telusko.simpleWebApp.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    public UsersDto addUser(UsersDto usersDto);

}
