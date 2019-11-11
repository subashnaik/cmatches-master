package com.stackroute.favouriteservice.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDTOs {
	
	@JsonProperty(value="data")
	List<EventDTO> events = new ArrayList<EventDTO>();

	public List<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventDTO> events) {
		this.events = events;
	}

}
