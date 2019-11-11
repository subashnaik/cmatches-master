package com.stackroute.favouriteservice.exception;

@SuppressWarnings("serial")
public class FavouriteMatchAlreadyExistsException extends Exception {

    public FavouriteMatchAlreadyExistsException(String message) {
        super(message);
    }
}
