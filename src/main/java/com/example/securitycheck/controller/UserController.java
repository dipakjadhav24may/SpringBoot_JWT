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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/organization")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header", defaultValue = "bearer ") })
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.findAll();
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header", defaultValue = "bearer ") })
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getOne(@PathVariable(value = "id") Long id) {
		return userService.findById(id);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header", defaultValue = "bearer ") })
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public User saveUser(@RequestBody UserDto user) {
		return userService.save(user);
	}
}
