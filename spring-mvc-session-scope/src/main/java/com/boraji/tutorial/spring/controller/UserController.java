package com.boraji.tutorial.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.boraji.tutorial.spring.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/info")
	public String userInfo(@SessionAttribute("user") User user) {
		System.out.println("Email:"+user.getEmail());
		System.out.println("First Name:"+user.getFname());
		return "user";
	}
	
	
	
}
