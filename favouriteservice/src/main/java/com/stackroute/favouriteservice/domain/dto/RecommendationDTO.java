package com.stackroute.favouriteservice.domain.dto;

public class RecommendationDTO {
	
	private Integer matchId;
    private Integer counter = 0;
    
    public RecommendationDTO() {
    	
    }
    
	public RecommendationDTO(Integer matchId, Integer counter) {
		super();
		this.matchId = matchId;
		this.counter = counter;
	}

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
