package com.stackroute.favouriteservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDTO {
	@JsonProperty(value="title")
	private String title;
	@JsonProperty(value="date")
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
