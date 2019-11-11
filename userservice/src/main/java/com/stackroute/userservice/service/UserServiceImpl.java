package com.stackroute.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.userservice.domain.model.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.IUserServiceRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserServiceRepository userServiceRepository;

	public UserServiceImpl(IUserServiceRepository userServiceRepository) {
		this.userServiceRepository = userServiceRepository;
	}

    @Override
    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
    	 return userServiceRepository.findByUserIdAndUserPassword(userId, password);
    }

    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {
    	return userServiceRepository.save(user) != null;
    }
}
