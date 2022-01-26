package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.userNotFoundException;

@Controller
public class UserController {
	
	@Autowired private UserService userser;
	
	@GetMapping("/users")
	public String showUserList(Model model) {
		List<User> listUsers=userser.ListAllUsers();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
    @GetMapping("/users/new")
    public String showNewForm(Model model) {
    	model.addAttribute("users", new User());
    	model.addAttribute("pageTitle","Add New User");
    	model.addAttribute("save","save");
    	
    	return "user_form";
    }
    
    @PostMapping("/users/save")
    public String save(User user ,RedirectAttributes ra) {
    	
    	userser.insertUser(user);
    	ra.addFlashAttribute("message","The user has been saved successfully");
    	return "redirect:/users";
    }
    @PostMapping("/users/edit")
    public String Edit(User user ,RedirectAttributes ra) {
    	
    	userser.insertUser(user);
    	ra.addFlashAttribute("message","The user has been saved successfully");
    	return "redirect:/users";
    }
    
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model, RedirectAttributes ra) throws userNotFoundException {
    	User theo=userser.getUserById(id);
    	if(theo!=null) {
    	model.addAttribute("users", theo);
    	model.addAttribute("pageTitle","Edit User  (ID: "+id+" )");
    	model.addAttribute("save","edit");
    	return"user_form";
    	}
    	else {
    		ra.addFlashAttribute("message", "");
    		return "redirect:/users";
    		
    		
    	}
    	
    	
  
    }
    
    @GetMapping("/users/delete/{id}")
    public String Delele(@PathVariable("id") long id, Model model, RedirectAttributes ra) throws userNotFoundException {
    	User theo=userser.getUserById(id);
    	
    	
    	if(userser.deleteUser(theo) && theo!=null) {
    		ra.addFlashAttribute("message","The user with Id  "+id+"has been Deleted successfully");
        	return "redirect:/users";
    		
    	}
    	
    	else {
    		ra.addFlashAttribute("message", "The user with Id  "+id+"has not been Deleted successfully");
    		return "redirect:/users";
    		
    		
    	}
    	
    	
  
    }
}
