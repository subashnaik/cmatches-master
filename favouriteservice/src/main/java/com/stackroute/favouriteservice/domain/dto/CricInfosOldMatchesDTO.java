package com.stackroute.favouriteservice.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CricInfosOldMatchesDTO {

	@JsonProperty(value="data")
	private List<CricInfoDTO> cricInfos;

	public List<CricInfoDTO> getCricInfos() {
		return cricInfos;
	}

	public void setCricInfos(List<CricInfoDTO> cricInfos) {
		this.cricInfos = cricInfos;
	}

	@Override
	public String toString() {
		return "CricInfos [cricInfos=" + cricInfos + "]";
	}
	
}
