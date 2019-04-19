package com.example.securitycheck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.securitycheck.model.User;
import com.example.securitycheck.service.UserServiceImpl;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminUserController {
	
	@Autowired
	private UserServiceImpl userService;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header", defaultValue = "bearer ") })
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listUserByAdmin() {
		return userService.findAll();
	}

}
