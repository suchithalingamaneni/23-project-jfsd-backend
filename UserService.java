package com.klu.promotehandlooms.service;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.promotehandlooms.model.User;
import com.klu.promotehandlooms.repo.UserInterface;

@Service
public class UserService implements UserImplementation{

	
	
	
	@Autowired
	private UserInterface uInterface;
     
	@Override
	public User register(User user) {
	return  uInterface.save(user);	
	}



	@Override
	public Map<String,Object> login(String email,String password){
		User user = uInterface.findByEmail(email);
		 Map<String, Object> response = new HashMap<>();
		if(user!=null && user.getPassword().equals(password)) {
			   response.put("success", true);
	           response.put("message", "Login successful");
		}
		else {
            response.put("success", false);
            response.put("message", "Invalid email or password");
        }

        return response;		
	}

}
