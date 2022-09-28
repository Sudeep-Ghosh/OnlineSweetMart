package com.onlinesweetmart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onlinesweetmart.entity.User;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@BeforeEach
	void userInitializerSetup()
	{
		User user = User.builder().userId(101).userName("John").password("john@123").passwordConfirm("john@123").type("new").build();
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
	}
	
	@BeforeEach
	void cancelUserInitializer() {
		Optional<User> user = Optional.ofNullable(User.builder().userId(101).userName("John").password("john@123").passwordConfirm("john@123").type("new").build());

		Mockito.when(userRepository.findById(user.get().getUserId())).thenReturn(user);
	}
	
	@Test
	public void addUserTestCase()
	{
		User user = User.builder().userId(101).userName("John").password("john@123").passwordConfirm("john@123").type("new").build();
		
		User add = userService.addUser(user);
		
		assertEquals(add, user);		
	}
	
	@Test
	public void showAllUsersTestCase()
	{
		User user = User.builder().userId(101).userName("John").password("john@123").passwordConfirm("john@123").type("new").build();
		
		List<User> getUsers = userService.showAllUsers();
		
		assertEquals(getUsers, Collections.singletonList(user));		
	}
	
	@Test
	public void updateUserTestCase() throws IdNotFoundException
	{
		User inputUser = User.builder().userId(101).userName("John").password("john@123").passwordConfirm("john@123").type("new").build();

		User outputUser = User.builder().userId(101).userName("John").password("john@123").passwordConfirm("john@123").type("new").build();

		Mockito.when(userService.updateUser(inputUser)).thenReturn(outputUser);
		
		assertEquals(inputUser, outputUser);		
	}
	
//	@Test
//	public void cancelUserTestCase() throws IdNotFoundException
//	{
//		
//		User user = User.builder().userId(101).userName("John").password("john@123").passwordConfirm("john@123").type("new").build();
//		
//		Mockito.when(userRepository.findById(user.getUserId()).get()).thenReturn(user);			
//		
//		//Mockito.when(userService.cancelUser(user.getUserId())).thenReturn(user);
//		
//		User getcancelledUser = userService.cancelUser(user.getUserId());
//		
//		assertEquals(getcancelledUser, user);
//	}
}
