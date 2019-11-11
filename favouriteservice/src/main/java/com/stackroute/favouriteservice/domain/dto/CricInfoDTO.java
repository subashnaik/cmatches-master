package com.stackroute.favouriteservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CricInfoDTO {

	@JsonProperty(value="unique_id")
	private int matchId;
	@JsonProperty(value="date")
	private String date;
	@JsonProperty(value="squad")
	private boolean squad;
	@JsonProperty(value="team-1")
	private String team1;
	@JsonProperty(value="team-2")
	private String team2;
	@JsonProperty(value="matchStarted")
	private String matchStarted;
	@JsonProperty(value="type")
	private String type;
	@JsonProperty(value="toss_winner_team")
	private String toss;
	@JsonProperty(value="winner_team")
	private String winner;
	@JsonProperty(value="stat")
	private String stat;
	@JsonProperty(value="score")
	private String score;
	@JsonProperty(value="description")
	private String description;
	@JsonProperty(value="title")
	private String title;
	@JsonProperty(value="matchtype")
	private String matchType;
	private int count = 0;
	private String favouriteType;
	
	public String getFavouriteType() {
		return favouriteType;
	}
	public void setFavouriteType(String favouriteType) {
		this.favouriteType = favouriteType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isSquad() {
		return squad;
	}
	public void setSquad(boolean squad) {
		this.squad = squad;
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
	public String getMatchStarted() {
		return matchStarted;
	}
	public void setMatchStarted(String matchStarted) {
		this.matchStarted = matchStarted;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getToss() {
		return toss;
	}
	public void setToss(String toss) {
		this.toss = toss;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	@Override
	public String toString() {
		return "CricInfoDTO [matchId=" + matchId + ", date=" + date + ", squad=" + squad + ", team1=" + team1
				+ ", team2=" + team2 + ", matchStarted=" + matchStarted + ", type=" + type + ", toss=" + toss
				+ ", winner=" + winner + ", stat=" + stat + ", score=" + score + ", description=" + description
				+ ", title=" + title + ", matchType=" + matchType + ", count=" + count + ", favouriteType="
				+ favouriteType + "]";
	}
	
    
}
