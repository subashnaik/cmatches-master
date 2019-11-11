package com.stackroute.favouriteservice.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.favouriteservice.config.messaging.Producer;
import com.stackroute.favouriteservice.domain.dto.CricInfoDTO;
import com.stackroute.favouriteservice.domain.dto.CricInfosDTO;
import com.stackroute.favouriteservice.domain.dto.CricInfosOldMatchesDTO;
import com.stackroute.favouriteservice.domain.dto.CricScoreDTO;
import com.stackroute.favouriteservice.domain.dto.EventDTO;
import com.stackroute.favouriteservice.domain.dto.FavouriteDTO;
import com.stackroute.favouriteservice.domain.dto.MatchDTO;
import com.stackroute.favouriteservice.domain.dto.MatchesDTO;
import com.stackroute.favouriteservice.domain.dto.RecommendationDTO;
import com.stackroute.favouriteservice.domain.dto.EventDTOs;
import com.stackroute.favouriteservice.domain.dto.UserDTO;
import com.stackroute.favouriteservice.domain.model.Favourite;
import com.stackroute.favouriteservice.domain.model.User;
import com.stackroute.favouriteservice.exception.FavouriteMatchAlreadyExistsException;
import com.stackroute.favouriteservice.exception.FavouriteMatchNotFoundException;
import com.stackroute.favouriteservice.exception.UserAlreadyExistsException;
import com.stackroute.favouriteservice.service.IFavouriteService;
import com.stackroute.favouriteservice.service.IUserService;

@RestController
@CrossOrigin(origins="http://localhost:8080")
public class FavouriteController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private Producer producer;

	@Autowired
	private IUserService userService;

	@Autowired
	private IFavouriteService favouriteService;

	public FavouriteController(Producer producer, RestTemplate restTemplate, IUserService userService,
			IFavouriteService favouriteService) {
		this.producer = producer;
		this.restTemplate = restTemplate;
		this.userService = userService;
		this.favouriteService = favouriteService;
	}

	@PostMapping(value = "/cricinfo/user/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception {
		try {
			if (userService.findByUserId(user.getUserId()) != null) {
				throw new UserAlreadyExistsException("User already exists !!");
			}
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			producer.registerUser(userDTO);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<String>("User Already Exist!!", HttpStatus.CONFLICT);
		}
	}

	@PostMapping(value = "/cricinfo/cricmatch/save/{type}/{userid}")
	public ResponseEntity<?> saveFavouriteMatch(@RequestBody Favourite favourite,
			@PathVariable("type") String type, @PathVariable("userid") String userId) throws Exception {
		try {
			if (favouriteService.findByFavouriteMatchId(userId, favourite.getMatchId()) != null) {
				throw new FavouriteMatchAlreadyExistsException("The favourite mathc already exists!!");
			}
			favourite.setUserId(userId);
			favourite.setMatchType(type);
			favouriteService.addFavouriteMatch(favourite);
			RecommendationDTO recommendationDTO = new RecommendationDTO();
			recommendationDTO.setMatchId(favourite.getMatchId());
			producer.addRecommendationMatch(recommendationDTO);
			return new ResponseEntity<Favourite>(favourite, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<String>("Favourite match already exists!!", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping(value = "/cricinfo/cricmatch/delete/{userid}/{matchid}")
	public ResponseEntity<?> deleteFavouriteMatch(@PathVariable("userid") String userId,
			@PathVariable("matchid") String matchId) throws Exception {
		try {
			Favourite favourite = favouriteService.findByFavouriteMatchId(userId, Integer.parseInt(matchId));
			if (favourite == null) {
				throw new FavouriteMatchNotFoundException("The favourite match was not found!!");
			}
			favourite.setUserId(userId);
			favouriteService.deleteFavouriteMatch(favourite);
			RecommendationDTO recommendationDTO = new RecommendationDTO();
			recommendationDTO.setMatchId(favourite.getMatchId());
			producer.updateRecommendationMatch(recommendationDTO);
			return new ResponseEntity<Favourite>(favourite, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("The favourite match has been deleted!!", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/cricinfo/cricmatch/get/{userid}")
	public ResponseEntity<?> getFavouriteMatches(@PathVariable("userid") String userId) throws Exception {
		List<Favourite> favourites = null;
		List<FavouriteDTO> favouritesDTO = null;
		FavouriteDTO favouriteDTO = null;
		try {
			favourites = favouriteService.getAllFavouriteMatches(userId);
			if (favourites == null || favourites.isEmpty()) {
				throw new FavouriteMatchNotFoundException("The favourite matches was not found!!");
			} else {
				favouritesDTO = new ArrayList<FavouriteDTO>(favourites.size());
				for (Favourite favourite : favourites) {
					favouriteDTO = new FavouriteDTO();
					BeanUtils.copyProperties(favourite, favouriteDTO);
					favouriteDTO.setFavouriteType("delete");
					if (favouriteDTO.getScore() != null) {
						favouriteDTO.setScore(favouriteDTO.getScore().replaceAll("&amp;", "&"));
					}
					if (favouriteDTO.getDescription() != null) {
						favouriteDTO.setDescription(favouriteDTO.getDescription().replaceAll("&amp;", "&"));
					}
					favouritesDTO.add(favouriteDTO);
				}
			}
			return new ResponseEntity<List<FavouriteDTO>>(favouritesDTO, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<String>("The favourite matches was not found!!", HttpStatus.NOT_FOUND);
		}
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/cricinfo/cricmatch/get/events")
	public EventDTOs getEvents() {
		List<EventDTO> events = new ArrayList<EventDTO>();
		MatchesDTO matches = restTemplate.getForObject("http://cricapi.com/api/matchCalendar/?apikey=I8EGGo2C2kU8eksn9lFZ9BIMVdW2", MatchesDTO.class);
		for (MatchDTO matchDTO : matches.getMatches()) {
			EventDTO event = new EventDTO();
			event.setTitle(matchDTO.getName());
			event.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date(matchDTO.getDate())));
			events.add(event);
		}
		EventDTOs eventsDTO = new EventDTOs();
		eventsDTO.setEvents(events);
		return eventsDTO;
				
	}
	
	@GetMapping(value = "/cricinfo/cricmatch/get/current")
	public ResponseEntity<?> getCurrentMatches() throws Exception {
		CricInfosDTO matches = null;
		try {
			matches = restTemplate.getForObject("http://cricapi.com/api/matches/?apikey=I8EGGo2C2kU8eksn9lFZ9BIMVdW2", CricInfosDTO.class);
			List<CricInfoDTO> sortMatches = matches.getCricInfos();
			sortMatches.sort(Comparator.comparing(c -> c.getMatchId()));
			sortMatches.sort(Comparator.comparing(c -> c.getDate()));
			List<CricInfoDTO> matchesWithStat = new ArrayList<CricInfoDTO>(sortMatches.size());
			int count = 0;
			for (CricInfoDTO cricInfo : sortMatches) {
				if ("true".equalsIgnoreCase(cricInfo.getMatchStarted())) {
					CricScoreDTO cricScore = restTemplate.getForObject("http://cricapi.com/api/cricketScore/?apikey=I8EGGo2C2kU8eksn9lFZ9BIMVdW2&unique_id=" + cricInfo.getMatchId(), CricScoreDTO.class);
					if (cricScore != null) {
						cricInfo.setMatchStarted(cricScore.getMatchStarted());
						cricInfo.setTeam1(cricScore.getTeam1());
						cricInfo.setTeam2(cricScore.getTeam2());
						cricInfo.setDescription(cricScore.getDescription());
						cricInfo.setScore(cricScore.getScore());
						cricInfo.setStat(cricScore.getStat());
						cricInfo.setMatchType("current");
						cricInfo.setFavouriteType("add");
						if (cricInfo.getScore() != null) {
							cricInfo.setScore(cricInfo.getScore().replaceAll("&amp;", "&"));
						}
						if (cricInfo.getDescription() != null) {
							cricInfo.setDescription(cricInfo.getDescription().replaceAll("&amp;", "&"));
						}
						if (cricInfo.getDescription() == null) {
							 cricInfo.setDescription("");
						}
						matchesWithStat.add(cricInfo);
					}
				}
				if (count ++ >= 20) {
					break;
				}
			}
			matches.setCricInfos(matchesWithStat);
		} catch (Exception e) {
			return new ResponseEntity<String>("The service is temporarily down, please try after some time", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CricInfosDTO>(matches, HttpStatus.OK);
	}
	
	@GetMapping(value = "/cricinfo/cricmatch/get/old")
	public ResponseEntity<?> getOldMatches() throws Exception {
		CricInfosOldMatchesDTO matches = null;
		try {
			matches = restTemplate.getForObject("http://cricapi.com/api/cricket/?apikey=I8EGGo2C2kU8eksn9lFZ9BIMVdW2", CricInfosOldMatchesDTO.class);
			List<CricInfoDTO> sortMatches = matches.getCricInfos();
			sortMatches.sort(Comparator.comparing(c -> c.getMatchId()));
			List<CricInfoDTO> matchesWithStat = new ArrayList<CricInfoDTO>(sortMatches.size());
			int count = 0;
			for (CricInfoDTO cricInfo : sortMatches) {
				CricScoreDTO cricScore = restTemplate.getForObject("http://cricapi.com/api/cricketScore/?apikey=I8EGGo2C2kU8eksn9lFZ9BIMVdW2&unique_id=" + cricInfo.getMatchId(), CricScoreDTO.class);
				if (cricScore != null) {
					cricInfo.setMatchStarted(cricScore.getMatchStarted());
					cricInfo.setTeam1(cricScore.getTeam1());
					cricInfo.setTeam2(cricScore.getTeam2());
					cricInfo.setDescription(cricScore.getDescription());
					cricInfo.setScore(cricScore.getScore());
					cricInfo.setStat(cricScore.getStat());
					cricInfo.setMatchType("old");
					cricInfo.setFavouriteType("add");
					if (cricInfo.getScore() != null) {
						cricInfo.setScore(cricInfo.getScore().replaceAll("&amp;", "&"));
					}
					if (cricInfo.getDescription() != null) {
						cricInfo.setDescription(cricInfo.getDescription().replaceAll("&amp;", "&"));
					}
					if (cricInfo.getDescription() == null) {
						 cricInfo.setDescription("");
					}
					matchesWithStat.add(cricInfo);
				}
				if (count ++ >= 20) {
					break;
				}
			}
			matches.setCricInfos(sortMatches);
		} catch (Exception e) {
			return new ResponseEntity<String>("The service is temporarily down, please try after some time", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CricInfosOldMatchesDTO>(matches, HttpStatus.OK);
	}

}
