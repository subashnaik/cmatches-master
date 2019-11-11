package com.stackroute.favouriteservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchDTO {
	@JsonProperty(value="unique_id")
	String id;
	@JsonProperty(value="name")
	String name;
	@JsonProperty(value="date")
	String date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
