package com.onlinesweetmart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
<<<<<<< HEAD
@Table(name = "users")
=======
@Table(name = "users") // change in name-user to users
>>>>>>> 164898db956d51ad25a6129c7abee5a2e32784cf
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	private String userName;
	private String password;
	private String passwordConfirm;
<<<<<<< HEAD
	private String type;	
=======
	private String type;
	
	//@OneToOne(mappedBy = "user")	
	//public Admin admin;
>>>>>>> 164898db956d51ad25a6129c7abee5a2e32784cf
}
