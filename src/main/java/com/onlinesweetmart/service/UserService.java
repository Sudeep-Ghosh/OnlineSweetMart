package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.User;

public interface UserService {
	
	public User addUser(User user);
	
	public User updateUser(User user, long userId);
	
	public void cancelUser(long userId);
	
	public List<User> showAllUsers();
}
