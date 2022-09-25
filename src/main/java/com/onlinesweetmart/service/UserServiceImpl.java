package com.onlinesweetmart.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.User;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.exception.InvalidPasswordException;
import com.onlinesweetmart.exception.InvalidUserNameException;
import com.onlinesweetmart.exception.PasswordMismatchException;
import com.onlinesweetmart.repository.UserRepository;
import com.onlinesweetmart.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserRepository userRepository;
	
	/*
	 * @Author : Kshitiz
	 * @Description : this is used to add a new user to the database
	 * @Param : it takes user as a parameter
	 * @Return : it returns the saved user
	 * @Date Created : 24 Sept 2022
	 * 
	 * */	
	
	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);			
		
	}

	/*
	 * @Author : Kshitiz
	 * @Description : this is used to update an existing user in the database
	 * @Param : it takes user and userId as parameters
	 * @Return : it returns updated user
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public User updateUser(User user, long userId) {
		
		User userDb =  userRepository.findById(userId).get();
		
		if(Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName()))
		{
			userDb.setUserName(user.getUserName());
		}	
		else {
			throw new InvalidUserNameException("Invalid User Name");
		}
		
		if(Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword()))
		{
			userDb.setPassword(user.getPassword());
		}
		else {
			throw new InvalidPasswordException("Invalid Password");
		}
		
		if(Objects.nonNull(user.getPasswordConfirm()) && !"".equalsIgnoreCase(user.getPasswordConfirm()))
		{
			userDb.setPasswordConfirm(user.getPasswordConfirm());
		}
		else {
			throw new PasswordMismatchException("The passwords do not match");
		}
		
		return userRepository.save(userDb);
	}

	/*
	 * @Author : Kshitiz
	 * @Description : this is used to delete a user from the database
	 * @Param : it takes userId as a parameter
	 * @Return : it does not return anything
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public void cancelUser(long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent())
		{
			userRepository.deleteById(userId);
		}
		else {
			throw new IdNotFoundException("No user found with the given id");
		}
	}

	/*
	 * @Author : Kshitiz
	 * @Description : this is used to show all the existing users in the database
	 * @Param : it does not take any parameter
	 * @Return : it returns a list of all the users
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public List<User> showAllUsers() {
		return userRepository.findAll();
	}

}
