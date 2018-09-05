package com.example.securitycheck.service;

import java.util.List;

import com.example.securitycheck.model.User;
import com.example.securitycheck.model.UserDto;

public interface UserService {
	
	User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);

}
