package com.stackroute.userservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.userservice.domain.model.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.service.IJWTTokenGeneratorService;
import com.stackroute.userservice.service.IUserService;

@RestController
@CrossOrigin(origins="http://localhost:8080")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	IJWTTokenGeneratorService jwtTokenService;
	
	private final Map<String, String> tokenMap = new HashMap<String, String>();
	
	public UserController(IUserService userService, IJWTTokenGeneratorService jwtTokenService) {
		this.userService = userService;
		this.jwtTokenService = jwtTokenService;
	}

	@PostMapping(value = "/cricinfo/user/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception {
		try {
			if (userService.findByUserIdAndPassword(user.getUserId(), user.getUserPassword()) != null) {
				throw new UserAlreadyExistsException("User already exists !!");
			}
			userService.saveUser(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (UserAlreadyExistsException ex) {
			return new ResponseEntity<String>("User Already Exist!!", HttpStatus.CONFLICT);
		}
	}
		
	@PostMapping(value="/cricinfo/user/login")
	public ResponseEntity<?> login(@RequestBody User user) throws ServletException {
		try {
			String jwtToken = jwtTokenService.generateToken(user.getUserId(), user.getUserPassword());
			tokenMap.put("message", "user successfully logged in");
			tokenMap.put("token", jwtToken);
		} catch (Exception e) {
			tokenMap.put("token", null);
			tokenMap.put("message", e.getMessage());
			return new ResponseEntity<>(tokenMap, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(tokenMap, HttpStatus.OK);
	}

}
