package com.stackroute.favouriteservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CricScoreDTO {
	@JsonProperty(value="stat")
	private String stat;
	@JsonProperty(value="score")
	private String score;
	@JsonProperty(value="description")
	private String description;
	@JsonProperty(value="matchStarted")
	private String matchStarted;
	@JsonProperty(value="team-1")
	private String team1;
	@JsonProperty(value="team-2")
	private String team2;
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMatchStarted() {
		return matchStarted;
	}
	public void setMatchStarted(String matchStarted) {
		this.matchStarted = matchStarted;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	@Override
	public String toString() {
		return "CricScoreDTO [stat=" + stat + ", score=" + score + ", description=" + description + ", matchStarted="
				+ matchStarted + ", team1=" + team1 + ", team2=" + team2 + "]";
	}
	
}
