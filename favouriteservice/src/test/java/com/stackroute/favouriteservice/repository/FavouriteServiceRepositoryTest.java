package com.stackroute.favouriteservice.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.favouriteservice.domain.model.Favourite;
import com.stackroute.favouriteservice.repository.IFavouriteServiceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FavouriteServiceRepositoryTest {
	
	@Autowired
	private IFavouriteServiceRepository favouriteServiceRepo;

	private Favourite favourite;
	private List<Favourite> favourites;

    @Before
    public void setUp(){
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
    	favouriteServiceRepo.deleteAll();
    	favourite=null;
    	favourites = null;
    }
    
    @Test
    public void testFindByUserIdAndMatchIdSuccess(){
    	favouriteServiceRepo.save(favourite);
    	Favourite favouriteObj = favouriteServiceRepo.findByUserIdAndMatchId(favourite.getUserId(), favourite.getMatchId());
        Assert.assertEquals(favourite.getTitle(), favouriteObj.getTitle());
        favouriteServiceRepo.delete(favourite);
    }
    
    @Test
    public void testFindAllFavouriteMatchesByUserIdSuccess(){
    	favouriteServiceRepo.saveAll(favourites);
    	List<Favourite> favouriteObj = favouriteServiceRepo.findAllFavouriteMatchesByUserId(favourite.getUserId());
        Assert.assertEquals(1, favouriteObj.size());
        favouriteServiceRepo.deleteAll();
    }

}
