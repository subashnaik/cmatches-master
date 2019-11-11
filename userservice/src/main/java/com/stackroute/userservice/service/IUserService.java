package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.model.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;

public interface IUserService {

    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;
    boolean saveUser(User user) throws UserAlreadyExistsException;
}
