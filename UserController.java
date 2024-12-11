package com.klu.promotehandlooms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.promotehandlooms.model.User;
import com.klu.promotehandlooms.service.UserImplementation;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserImplementation urImplementation;
	@PostMapping("/register")
	public User register(@RequestBody User user) {
//		user.setPassword(encoder.encode(user.getPassword()));
		return urImplementation.register(user);
	}
	
	@PostMapping("/login")
	public Map<String,Object> loginUser(@RequestBody Map<String,String> cred){
		String email = cred.get("email");
		String password = cred.get("password");
		Map<String,Object> response = urImplementation.login(email, password);
		return response;
	}
}
