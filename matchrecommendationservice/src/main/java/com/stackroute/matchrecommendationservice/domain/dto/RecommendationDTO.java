package com.stackroute.matchrecommendationservice.domain.dto;

public class RecommendationDTO {
	
	private Integer matchId;
    private Integer counter = 0;

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "Recommendation [matchId=" + matchId + ", counter=" + counter + "]";
	}
    
}
