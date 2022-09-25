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
import com.onlinesweetmart.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserServiceImpl userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable("userId") long userId)
	{
		return userService.updateUser(user, userId);
	}
	
	@DeleteMapping("/cancelUser/{userId}")
	public void cancelUser(@PathVariable("userId") long userId)
	{
		userService.cancelUser(userId);
	}
	
	@GetMapping("/showAllUsers")
	public List<User> showAllUsers()
	{
		return userService.showAllUsers();
	}
}
