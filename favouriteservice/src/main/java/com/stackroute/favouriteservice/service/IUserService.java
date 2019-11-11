package com.stackroute.favouriteservice.service;

import com.stackroute.favouriteservice.domain.model.User;

public interface IUserService {

	public User findByUserId(String uisrId);
	
}
