package com.stackroute.favouriteservice.service;


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

import com.stackroute.favouriteservice.domain.model.Favourite;
import com.stackroute.favouriteservice.domain.model.User;
import com.stackroute.favouriteservice.repository.IFavouriteServiceRepository;
import com.stackroute.favouriteservice.service.FavouriteServiceImpl;

public class FavouriteServiceImplTest {
	
	@Mock
	private IFavouriteServiceRepository favouriteServiceRepo;
	
    @InjectMocks
    private FavouriteServiceImpl favouriteServiceImpl;
	
	private User user;
	private Favourite favourite;
	private List<Favourite> favourites;
	
	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		user = new User();
		user.setFirstName("Naresh");
		user.setLastName("Kumar");
		user.setUserId("naresh1");
		user.setUserPassword("pass");
		user.setUserRole("admin");
		
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
		
		favourites = new ArrayList<Favourite>();
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
		favourite.setTeam2("Srilanka");
		favourite.setTitle("ind vs sl, t20 match");
		favourite.setToss("India");
		favourite.setType("T20");
		favourite.setUserId("naresh1");
		favourite.setWinner("India");
		
		favourites.add(favourite);
    }

    @After
    public void tearDown(){
    	user = null;
    	favourite = null;
    }
    
    @Test
    public void testByFavouriteMatchIdSuccess(){
        Mockito.when(favouriteServiceRepo.findByUserIdAndMatchId(user.getUserId(), favourite.getMatchId())).thenReturn(favourite);
        Favourite fav = favouriteServiceImpl.findByFavouriteMatchId(user.getUserId(), favourite.getMatchId());
        Assert.assertEquals(favourite, fav);
    }
    
    @Test
    public void testAddFavouriteMatchSuccess(){
        Mockito.when(favouriteServiceRepo.save(favourite)).thenReturn(favourite);
        Favourite fav = favouriteServiceImpl.addFavouriteMatch(favourite);
        Assert.assertEquals(favourite, fav);
    }
    
    @Test
    public void testGetAllFavouriteMatchesSuccess(){
        Mockito.when(favouriteServiceRepo.findAllFavouriteMatchesByUserId(user.getUserId())).thenReturn(favourites);
        List<Favourite> favs = favouriteServiceImpl.getAllFavouriteMatches(user.getUserId());
        Assert.assertEquals(favourites, favs);
    }

}
