package com.stackroute.userservice.service;

import java.util.Calendar;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.userservice.domain.model.User;
import com.stackroute.userservice.exception.UserNotFoundException;

@Component
public class JWTTokenGeneratorServiceImpl implements IJWTTokenGeneratorService {

	@Autowired
	private IUserService userService;
	
	public JWTTokenGeneratorServiceImpl(IUserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String generateToken(String userName, String password) throws UserNotFoundException {
		if (userName == null || password == null) {
			throw new UserNotFoundException("Please pass both user name and password");
		}
		User user = null;
		try {
			user = userService.findByUserIdAndPassword(userName, password);
		} catch (Exception e) {
			throw new UserNotFoundException("User not found");
		}
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
        
		return Jwts.builder().setSubject(userName).setIssuedAt(Calendar.getInstance().getTime())
			.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	}


}
