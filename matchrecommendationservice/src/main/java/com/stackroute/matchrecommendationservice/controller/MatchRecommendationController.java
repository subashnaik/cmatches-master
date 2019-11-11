package com.stackroute.matchrecommendationservice.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.matchrecommendationservice.domain.dto.FavouriteDTO;
import com.stackroute.matchrecommendationservice.domain.model.Favourite;
import com.stackroute.matchrecommendationservice.domain.model.Recommendation;
import com.stackroute.matchrecommendationservice.exception.RecommendationMatchNotFoundException;
import com.stackroute.matchrecommendationservice.service.IFavouriteService;
import com.stackroute.matchrecommendationservice.service.IRecommendationService;

@RestController
@CrossOrigin(origins="http://localhost:8080")
public class MatchRecommendationController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private IRecommendationService recommendationService;
	
	@Autowired
	private IFavouriteService favouriteService;
	
	public MatchRecommendationController(IRecommendationService recommendationService, IFavouriteService favouriteService) {
		this.recommendationService = recommendationService;
		this.favouriteService = favouriteService;
	}
	
	@GetMapping(value = "/cricinfo/cricmatch/get")
	public ResponseEntity<?> getRecommendedMatches() throws Exception {
		try {
			List<Recommendation> recommendations = recommendationService.findAllRecommendedMatches();
			if (recommendations == null) {
				throw new RecommendationMatchNotFoundException("The Recommended matches not found!!");
			}
			List<FavouriteDTO> favourites = new ArrayList<FavouriteDTO>(recommendations.size());
			Favourite favourite = null;
			for (Recommendation recommendation : recommendations) {
				favourite = favouriteService.findByFavouriteMatchId(recommendation.getMatchId());
				FavouriteDTO favouriteDTO = new FavouriteDTO();
				BeanUtils.copyProperties(favourite, favouriteDTO);
				favouriteDTO.setCount(recommendation.getCounter().intValue());
				favourites.add(favouriteDTO);
			}
			return new ResponseEntity<List<FavouriteDTO>>(favourites, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("The Recommended matches not found!!", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/cricinfo/cricmatch/save/{matchid}")
	public ResponseEntity<String> saveRecommendedMatch(@PathVariable("matchid") String matchId) throws Exception {
		try {
			recommendationService.addRecommendationMatch(Integer.parseInt(matchId));
			return new ResponseEntity<String>("Recommended match has been added!!", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping(value = "/cricinfo/cricmatch/delete/{matchid}")
	public ResponseEntity<String> updateRecommendedMatch(@PathVariable("matchid") String matchId) throws Exception {
		try {
			recommendationService.updateRecommendationMatch(Integer.parseInt(matchId));
			return new ResponseEntity<String>("The Recommendation match has been deleted!!", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/cricinfo/cricmatch/get/{matchid}")
	public ResponseEntity<?> getRecommendedMatch(@PathVariable("matchid") String matchId) throws Exception {
		try {
			Recommendation recommendation = recommendationService.findByRecommendationMatchId(Integer.parseInt(matchId));
			if (recommendation == null) {
				throw new RecommendationMatchNotFoundException("The Recommended match not found!!");
			}
			Favourite favourite = favouriteService.findByFavouriteMatchId(Integer.parseInt(matchId));
			return new ResponseEntity<Favourite>(favourite, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
