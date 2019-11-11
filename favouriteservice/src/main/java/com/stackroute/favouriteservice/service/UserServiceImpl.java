package com.stackroute.favouriteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favouriteservice.domain.model.User;
import com.stackroute.favouriteservice.repository.IUserServiceRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserServiceRepository userServiceRepository;

	public UserServiceImpl(IUserServiceRepository userServiceRepository) {
		this.userServiceRepository = userServiceRepository;
	}

    @Override
    public User findByUserId(String userId) {
    	 return userServiceRepository.findByUserId(userId);
    }

}
