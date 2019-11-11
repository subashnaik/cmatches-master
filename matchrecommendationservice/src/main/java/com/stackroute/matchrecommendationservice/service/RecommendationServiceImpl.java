package com.stackroute.matchrecommendationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.matchrecommendationservice.domain.model.Recommendation;
import com.stackroute.matchrecommendationservice.repository.IRecommendationServiceRepository;

@Service
public class RecommendationServiceImpl implements IRecommendationService{

	@Autowired
	private IRecommendationServiceRepository recommendationRepository;
	
	public RecommendationServiceImpl(IRecommendationServiceRepository recommendationRepository) {
		this.recommendationRepository = recommendationRepository;
	}

	@Override
	public Recommendation findByRecommendationMatchId(Integer matchId) {
		return recommendationRepository.findByMatchId(matchId);
	}
	
	@Override
	public List<Recommendation> findAllRecommendedMatches() {
		return recommendationRepository.findAll();
	}

	@Override
	public Recommendation addRecommendationMatch(int matchId) {
		Recommendation recommendation = findByRecommendationMatchId(matchId);
		if (recommendation != null) {
			recommendation.setCounter(recommendation.getCounter() + 1);
		} else {
			recommendation = new Recommendation();
			recommendation.setMatchId(matchId);
			recommendation.setCounter(1);
		}
		return recommendationRepository.save(recommendation);
	}

	@Override
	public void updateRecommendationMatch(int matchId) {
		Recommendation recommendation = findByRecommendationMatchId(matchId);
		if (recommendation != null) {
			recommendation.setCounter(recommendation.getCounter() - 1);
		}
		if (recommendation.getCounter() == 0) {
			recommendationRepository.delete(recommendation);
		} else {
			recommendationRepository.updateByMatchId(recommendation.getCounter(), recommendation.getMatchId());
		}
	}

}
