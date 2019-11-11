package com.stackroute.matchrecommendationservice.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Favourite")
@IdClass(FavouriteId.class)
public class Favourite {
	
	@Id
    @Column(length = 30)
	private Integer matchId;
	
	@Id
	@Column(length = 30)
	private String userId;
	
    @Column(length = 30)
	private String date;
    @Column(length = 5)
	private boolean squad;
    @Column(length = 50)
	private String team1;
    @Column(length = 50)
	private String team2;
    @Column(length = 20)
	private String matchStarted;
    @Column(length = 90)
	private String description;
    @Column(length = 50)
	private String title;
    @Column(length = 20)
  	private String type;
    @Column(length = 50)
    private String toss;
    @Column(length = 30)
    private String winner;
    @Column(length = 90)
    private String stat;
    @Column(length = 90)
    private String score;
    @Column(length = 20)
    private String matchType;
      
    
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
		return "Favourite [matchId=" + matchId + ", userId=" + userId + ", date=" + date + ", squad=" + squad
				+ ", team1=" + team1 + ", team2=" + team2 + ", matchStarted=" + matchStarted + ", description="
				+ description + ", title=" + title + ", type=" + type + ", toss=" + toss + ", winner=" + winner
				+ ", stat=" + stat + ", score=" + score + ", matchType=" + matchType + "]";
	}
	
}
