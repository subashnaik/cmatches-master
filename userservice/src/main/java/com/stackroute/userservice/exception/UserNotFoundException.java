package com.stackroute.userservice.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }
}
