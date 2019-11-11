package com.stackroute.matchrecommendationservice.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.matchrecommendationservice.domain.model.Recommendation;
import com.stackroute.matchrecommendationservice.repository.IRecommendationServiceRepository;

public class RecommendationServiceImplTest {

	@Mock
	private IRecommendationServiceRepository recommendationRepository;
	
    @InjectMocks
    private RecommendationServiceImpl recommendationServiceImpl;
	
	private Recommendation recommendation;
	private List<Recommendation> recommendations;
	
	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		recommendation = new Recommendation();
		recommendation.setMatchId(123);
		recommendation.setCounter(2);
		
		recommendations = new ArrayList<Recommendation>(2);
		recommendations.add(recommendation);
		
		recommendation = new Recommendation();
		recommendation.setMatchId(234);
		recommendation.setCounter(4);
		recommendations.add(recommendation);
    }

    @After
    public void tearDown(){
    	recommendation = null;
    }

	
	@Test
	public void testFindByRecommendationMatchId() {
		Mockito.when(recommendationRepository.findByMatchId(recommendation.getMatchId())).thenReturn(recommendation);
		Recommendation recommendationObj = recommendationServiceImpl.findByRecommendationMatchId(recommendation.getMatchId());
        Assert.assertEquals(recommendation, recommendationObj);
	}
	
	@Test
	public void testFindAllRecommendedMatches() {
		Mockito.when(recommendationRepository.findAll()).thenReturn(recommendations);
		List<Recommendation> recommendationObjs = recommendationServiceImpl.findAllRecommendedMatches();
        Assert.assertEquals(recommendations.size(), recommendationObjs.size());
	}
	
	@Test
	public void testAddRecommendationMatch() {
		Mockito.when(recommendationRepository.findByMatchId(recommendation.getMatchId())).thenReturn(recommendation);
		Mockito.when(recommendationRepository.save(recommendation)).thenReturn(recommendation);
		Recommendation recommendationObj = recommendationServiceImpl.addRecommendationMatch(recommendation.getMatchId());
        Assert.assertEquals(Integer.valueOf(5), recommendationObj.getCounter());
	}
	
	@Test
	public void testUpdateRecommendationMatch() {
		Mockito.when(recommendationRepository.findByMatchId(recommendation.getMatchId())).thenReturn(recommendation);
		Mockito.when(recommendationRepository.updateByMatchId(recommendation.getCounter(), recommendation.getMatchId())).thenReturn(1);
		recommendationServiceImpl.updateRecommendationMatch(recommendation.getMatchId());
		Assert.assertEquals(Integer.valueOf(3), recommendation.getCounter());
	}

}
