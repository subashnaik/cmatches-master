package com.stackroute.favouriteservice.exception;

@SuppressWarnings("serial")
public class FavouriteMatchNotFoundException extends Exception {

	public FavouriteMatchNotFoundException() {
		super();
	}
	
	public FavouriteMatchNotFoundException(String msg) {
		super(msg);
	}

}
