package com.onlinesweetmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetmart.entity.User;
import com.onlinesweetmart.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	public UserServiceImpl userService;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{userId}")
	public User cancelUser(@PathVariable("userId") long userId)
	{
		return userService.cancelUser(userId);
	}
	
	@GetMapping("/user")
	public List<User> showAllUsers()
	{
		return userService.showAllUsers();
	}
}
