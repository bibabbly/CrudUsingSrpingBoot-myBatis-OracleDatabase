package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.userRepository;

@Service
public class UserService {
	
	@Autowired private userRepository userRepo;
	
	public List<User> ListAllUsers(){		
		return userRepo.findAllUsers();
	}
	
	public void insertUser(User user) {
		
		userRepo.InsertUser(user);
	}
	
	public boolean deleteUser(User user) {
		
		return userRepo.deleteUser(user);
	}
	
	   public User getUserById(long id) throws userNotFoundException {
		   
		   User result=userRepo.getUserById(id);
		   
		   if(result !=null) {
			   
			   return result;
		   }
		   
		 throw new userNotFoundException("Could not find any User with an ID "+id);
	   }

}
