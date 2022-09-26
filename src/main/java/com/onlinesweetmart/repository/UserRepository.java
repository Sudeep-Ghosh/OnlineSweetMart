package com.onlinesweetmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.onlinesweetmart.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User addUser(User user);
	
	public User updateUser(User user, long userId);
	
	public User cancelUser(long userId);
	
	public List<User> showAllUsers();
}
