package com.stackroute.matchrecommendationservice.service;

import java.util.List;

import com.stackroute.matchrecommendationservice.domain.model.Recommendation;

public interface IRecommendationService {
	
	public Recommendation findByRecommendationMatchId(Integer matchId);
	
	public Recommendation addRecommendationMatch(int matchId);
	
	public void updateRecommendationMatch(int matchId);
	
	public List<Recommendation> findAllRecommendedMatches();
	
}
