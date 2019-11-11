package com.stackroute.favouriteservice.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.favouriteservice.config.messaging.Producer;
import com.stackroute.favouriteservice.controller.FavouriteController;
import com.stackroute.favouriteservice.domain.dto.RecommendationDTO;
import com.stackroute.favouriteservice.domain.dto.UserDTO;
import com.stackroute.favouriteservice.domain.model.Favourite;
import com.stackroute.favouriteservice.domain.model.User;
import com.stackroute.favouriteservice.service.IFavouriteService;
import com.stackroute.favouriteservice.service.IUserService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class FavouriteControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private Producer producer;

	@MockBean
	private IUserService userService;

	@MockBean
	private IFavouriteService favouriteService;
	
	@InjectMocks
	private FavouriteController favouriteController;
	
	private User user;
	private Favourite favourite;
	private List<Favourite> favourites;
	private RecommendationDTO recommendationDTO;
	private UserDTO userDTO;;
	
	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(favouriteController).build();
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
		favourite.setMatchId(234);
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
		recommendationDTO = new RecommendationDTO();
		recommendationDTO.setMatchId(favourite.getMatchId());
		userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		
    }

    @After
    public void tearDown(){
    	user = null;
    	favourite = null;
    	recommendationDTO = null;
    	userDTO = null;
    }

    @Test
	public void testRegisterUser() throws Exception {
	 	when(userService.findByUserId(user.getUserId())).thenReturn(null);
	 	doNothing().when(producer).registerUser(userDTO);
	    mockMvc.perform(post("/cricinfo/user/register", user)
	    .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonToString(user)))
	            .andExpect(status().isCreated()).andDo(print());
	    verify(userService, times(1)).findByUserId(user.getUserId());
	}

	@Test
	public void testSaveFavouriteMatchSuccess() throws Exception {
		when(favouriteService.findByFavouriteMatchId(user.getUserId(), favourite.getMatchId())).thenReturn(null);
		doNothing().when(producer).addRecommendationMatch(recommendationDTO);
	    mockMvc.perform(post("/cricinfo/cricmatch/save/{type}/{userid}", favourite.getType(), favourite.getUserId())
	    .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonToString(favourite)))
	            .andExpect(status().isCreated()).andDo(print());
	}
	
	@Test
	public void testSaveFavouriteMatchFailure() throws Exception {
		when(favouriteService.findByFavouriteMatchId(user.getUserId(), favourite.getMatchId())).thenReturn(favourite);
	    mockMvc.perform(post("/cricinfo/cricmatch/save/{type}/{userid}", favourite.getType(), favourite.getUserId())
	    .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonToString(favourite)))
	            .andExpect(status().isConflict()).andDo(print());
	}

	@Test
	public void testDeleteFavouriteMatchSuccess() throws Exception {
		when(favouriteService.findByFavouriteMatchId(user.getUserId(), favourite.getMatchId())).thenReturn(favourite);
	    mockMvc.perform(delete("/cricinfo/cricmatch/delete/{userid}/{matchid}", favourite.getUserId(), favourite.getMatchId())
	    .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonToString(favourite)))
	            .andExpect(status().isOk()).andDo(print());
	    verify(favouriteService, times(1)).deleteFavouriteMatch(favourite);
	}
	
	@Test
	public void testDeleteFavouriteMatchFailure() throws Exception {
		when(favouriteService.findByFavouriteMatchId(user.getUserId(), favourite.getMatchId())).thenReturn(null);
	    mockMvc.perform(delete("/cricinfo/cricmatch/delete/{userid}/{matchid}", favourite.getUserId(), favourite.getMatchId())
	    .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonToString(favourite)))
	            .andExpect(status().isNotFound()).andDo(print());
	}

	@Test
	public void testGetFavouriteMatches() throws Exception {
		when(favouriteService.getAllFavouriteMatches(user.getUserId())).thenReturn(favourites);
	    mockMvc.perform(get("/cricinfo/cricmatch/get/{userid}", user.getUserId())
	    .contentType(MediaType.APPLICATION_JSON)
	            .content(jsonToString(favourite)))
	            .andExpect(status().isOk()).andDo(print());
	    verify(favouriteService, times(1)).getAllFavouriteMatches(user.getUserId());
	}
	
	 private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try{
            result = new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e){
            result = "JSON Processing Error";
        }
        return result;
	}

}
