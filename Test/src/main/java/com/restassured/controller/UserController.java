package com.restassured.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restassured.bean.User;

@RequestMapping("/user")
@RestController
public class UserController {

	@RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	public User getUserById(@RequestParam(value = "id", required = false, defaultValue = "10" ) String id) {
		return getUser(id);
	}

	private User getUser(String id) {
		
		User user = new User();
		user.setId(id);
		user.setEmail("email" + id + "@test.com");
		user.setName("Name_" + id);
		return user;
	}
	
	
	
	
}
