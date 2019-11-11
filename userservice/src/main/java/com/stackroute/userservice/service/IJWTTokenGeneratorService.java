package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.UserNotFoundException;

public interface IJWTTokenGeneratorService {
	
	public String generateToken(String userName, String password) throws UserNotFoundException;

}
