package com.stackroute.favouriteservice.domain.dto;

public class FavouriteDTO {
	
	private Integer matchId;
	private String userId;
	private String date;
	private boolean squad;
	private String team1;
	private String team2;
	private String matchStarted;
	private String description;
	private String title;
	private String type;
    private String toss;
    private String winner;
    private String stat;
    private String score;
    private String matchType;
    private String favouriteType;
    
	public String getFavouriteType() {
		return favouriteType;
	}
	public void setFavouriteType(String favouriteType) {
		this.favouriteType = favouriteType;
	}
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	@Override
	public String toString() {
		return "FavouriteDTO [matchId=" + matchId + ", userId=" + userId + ", date=" + date + ", squad=" + squad
				+ ", team1=" + team1 + ", team2=" + team2 + ", matchStarted=" + matchStarted + ", description="
				+ description + ", title=" + title + ", type=" + type + ", toss=" + toss + ", winner=" + winner
				+ ", stat=" + stat + ", score=" + score + ", matchType=" + matchType + ", favouriteType="
				+ favouriteType + "]";
	}
	
	
}
