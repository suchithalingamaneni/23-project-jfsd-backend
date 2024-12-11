package com.klu.promotehandlooms.service;

import java.util.Map;

import com.klu.promotehandlooms.model.User;

public interface UserImplementation {

public User register(User user); 

public Map<String,Object> login(String email,String password);


}
