package com.boraji.tutorial.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.boraji.tutorial.spring.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {

	@ModelAttribute("user")
	public User setUpUserForm() {
		return new User();
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/dologin")
	public String doLogin(@ModelAttribute("user") User user, Model model) {
		
		
		if(user.getEmail().equals("sunil@example.com")&& user.getPassword().equals("abc@123")) {
		
			user.setFname("Sunil");
			user.setMname("Singh");
			user.setLname("Bora");
			user.setAge(28);
			
			
		}else {
			model.addAttribute("message","Login failed.Try again.");
			return "index";
		}
		
		return "success";
	}
	
	
}
