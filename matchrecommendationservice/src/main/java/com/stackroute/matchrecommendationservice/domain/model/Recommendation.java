package com.stackroute.matchrecommendationservice.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Recommendation")
public class Recommendation {
	
	@Id
    @Column(length = 30)
	private Integer matchId;
	
    @Column(length = 30)
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
