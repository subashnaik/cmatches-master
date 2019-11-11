package com.stackroute.matchrecommendationservice.exception;

@SuppressWarnings("serial")
public class RecommendationMatchNotFoundException extends Exception {

	public RecommendationMatchNotFoundException() {
		super();
	}
	
	public RecommendationMatchNotFoundException(String msg) {
		super(msg);
	}

}
