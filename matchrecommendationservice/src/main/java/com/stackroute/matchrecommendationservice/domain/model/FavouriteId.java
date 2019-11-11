package com.stackroute.matchrecommendationservice.domain.model;

import java.io.Serializable;

public class FavouriteId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer matchId;
	
	private String userId;
	
	public FavouriteId() {
		
	}
	
	public FavouriteId(Integer matchId, String userId) {
		super();
		this.matchId = matchId;
		this.userId = userId;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matchId == null) ? 0 : matchId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavouriteId other = (FavouriteId) obj;
		if (matchId == null) {
			if (other.matchId != null)
				return false;
		} else if (!matchId.equals(other.matchId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	

}
