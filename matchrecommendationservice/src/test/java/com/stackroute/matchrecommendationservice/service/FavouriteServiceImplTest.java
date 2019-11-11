package com.stackroute.matchrecommendationservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.matchrecommendationservice.domain.model.Favourite;
import com.stackroute.matchrecommendationservice.repository.IFavouriteServiceRepository;

public class FavouriteServiceImplTest {
	
	@Mock
	private IFavouriteServiceRepository favouriteServiceRepo;
	
    @InjectMocks
    private FavouriteServiceImpl favouriteServiceImpl;
	
	private Favourite favourite;
	private List<Favourite> favourites;
	
	
	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		favourite = new Favourite();
		favourite.setDate(new Date().toString());
		favourite.setDescription("ind vs bng, t20 match");
		favourite.setMatchId(123);
		favourite.setMatchStarted("true");
		favourite.setMatchType("T20");
		favourite.setScore("Ind 200/2 vs Bng 180/9");
		favourite.setSquad(true);
		favourite.setStat("Ind 200/2 vs Bng 180/9");
		favourite.setTeam1("India");
		favourite.setTeam2("Bangladesh");
		favourite.setTitle("ind vs bng, t20 match");
		favourite.setToss("India");
		favourite.setType("T20");
		favourite.setUserId("naresh1");
		favourite.setWinner("India");
		
		favourites = new ArrayList<Favourite>(2);
		favourites.add(favourite);
		
		favourite = new Favourite();
		favourite.setDate(new Date().toString());
		favourite.setDescription("ind vs sl, t20 match");
		favourite.setMatchId(123);
		favourite.setMatchStarted("true");
		favourite.setMatchType("T20");
		favourite.setScore("Ind 200/2 vs Sl 180/9");
		favourite.setSquad(true);
		favourite.setStat("Ind 200/2 vs Sl 180/9");
		favourite.setTeam1("India");
		favourite.setTeam2("Srlanka");
		favourite.setTitle("ind vs sl, t20 match");
		favourite.setToss("India");
		favourite.setType("T20");
		favourite.setUserId("naresh1");
		favourite.setWinner("India");
		favourites.add(favourite);
    }

    @After
    public void tearDown(){
    	favourite = null;
    }
    
    @Test
    public void testFindByFavouriteMatchId(){
        Mockito.when(favouriteServiceRepo.findByMatchId(favourite.getMatchId())).thenReturn(favourites);
        Favourite fav = favouriteServiceImpl.findByFavouriteMatchId(favourite.getMatchId());
        Assert.assertEquals(favourites.get(0), fav);
    }
    
}
