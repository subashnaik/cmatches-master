package com.stackroute.favouriteservice.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchesDTO {

	@JsonProperty(value="data")
	private List<MatchDTO> matches;

	public List<MatchDTO> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchDTO> matches) {
		this.matches = matches;
	}
	
	

}
