package com.onlinesweetmart.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.User;
import com.onlinesweetmart.exception.EmptyUserListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.exception.InvalidPasswordException;
import com.onlinesweetmart.exception.InvalidUserNameException;
import com.onlinesweetmart.exception.PasswordMismatchException;
import com.onlinesweetmart.exception.UserAlreadyExistsException;
import com.onlinesweetmart.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserRepository userRepository;
	
	/*
	 * @Author : Kshitiz Zamindar
	 * @Description : This is used to add a new user to the database
	 * @Param : It takes user as a parameter
	 * @Return : It returns the saved user
	 * @Date Created : 24 Sept 2022
	 * 
	 * */	
	
	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);			
		
	}

	/*
	 * @Author : Kshitiz Zamindar
	 * @Description : This is used to update an existing user in the database
	 * @Param : It takes user and userId as parameters
	 * @Return : It returns updated user
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public User updateUser(User user) {
		
		Optional<User> userDb =  userRepository.findById(user.getUserId());
		
		if(userDb.isPresent())
		{
			if(Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName()))
			{
				userDb.get().setUserName(user.getUserName());
			}	
			else {
				throw new InvalidUserNameException("Invalid User Name");
			}
			
			if(Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword()))
			{
				userDb.get().setPassword(user.getPassword());
			}
			else {
				throw new InvalidPasswordException("Invalid Password");
			}
			
			if(Objects.nonNull(user.getPasswordConfirm()) && !"".equalsIgnoreCase(user.getPasswordConfirm()) && user.getPassword().equalsIgnoreCase(user.getPasswordConfirm()))
			{
				userDb.get().setPasswordConfirm(user.getPasswordConfirm());
			}
			else {
				throw new PasswordMismatchException("The passwords do not match");
			}
			
			if(Objects.nonNull(user.getType()) && !"".equalsIgnoreCase(user.getType()))
			{
				userDb.get().setType(user.getType());
			}
			else {
				throw new UserAlreadyExistsException("User with id: " + user.getUserId() + " already exists");
			}
			userRepository.save(userDb.get());
			return userDb.get();
		}
		else {
			throw new IdNotFoundException("No user found with the user id: " + user.getUserId());
		}			
	}

	/*
	 * @Author : Kshitiz Zamindar
	 * @Description : This is used to delete a user from the database
	 * @Param : It takes userId as a parameter
	 * @Return : It does not return anything
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public User cancelUser(long userId)
	{
		User user;
		if(userRepository.existsById(userId))
		{
			user = userRepository.findById(userId).get();
			userRepository.deleteById(userId);
			return user;
		}
		else {
			throw new IdNotFoundException("No user found with the given id");
		}
	}

	/*
	 * @Author : Kshitiz Zamindar
	 * @Description : This is used to show all the existing users in the database
	 * @Param : It does not take any parameter
	 * @Return : It returns a list of all the users
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public List<User> showAllUsers() {
		
		List<User> userList = userRepository.findAll();
		if(userList.isEmpty())
		{
			throw new EmptyUserListException("No user found in the user list");
		}
		return userList;
	}
}
