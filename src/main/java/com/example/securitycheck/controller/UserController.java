package com.example.securitycheck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitycheck.model.User;
import com.example.securitycheck.model.UserDto;
import com.example.securitycheck.service.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	 @Autowired
	    private UserServiceImpl userService;

	    @RequestMapping(value="/users", method = RequestMethod.GET)
	    public List<User> listUser(){
	        return userService.findAll();
	    }

	    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	    public User getOne(@PathVariable(value = "id") Long id){
	        return userService.findById(id);
	    }

	    @RequestMapping(value="/signup", method = RequestMethod.POST)
	    public User saveUser(@RequestBody UserDto user){
	        return userService.save(user);
	    }
}
