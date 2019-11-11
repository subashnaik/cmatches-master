package com.stackroute.favouriteservice.service;

import java.util.List;

import com.stackroute.favouriteservice.domain.model.Favourite;

public interface IFavouriteService {
	
	public Favourite findByFavouriteMatchId(String userId, Integer id);
	
	public Favourite addFavouriteMatch(Favourite favourite);
	
	public void deleteFavouriteMatch(Favourite favourite);
	
	public List<Favourite> getAllFavouriteMatches(String userId);

}
