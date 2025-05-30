package com.telusko.simpleWebApp.serviceImpl;

import com.telusko.simpleWebApp.dto.UsersDto;
import com.telusko.simpleWebApp.entity.Users;
import com.telusko.simpleWebApp.repository.UserRepo;
import com.telusko.simpleWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UsersDto addUser(UsersDto usersDto) {
       Users users=dtoToEntity(usersDto);
       userRepo.save(users);
       return entityToDto(users);
    }

    public Users dtoToEntity(UsersDto usersDto)
    {
        Users users=new Users();
        users.setId(usersDto.getId());
        users.setName(usersDto.getName());
        users.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        return users;
    }
    public UsersDto entityToDto(Users users)
    {
        UsersDto usersDto=new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setName(users.getName());
        usersDto.setPassword(users.getPassword());
        return usersDto;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users users=userRepo.findByName(name);
        return new User(users.getName(),users.getPassword(), Collections.emptyList());
    }


}
