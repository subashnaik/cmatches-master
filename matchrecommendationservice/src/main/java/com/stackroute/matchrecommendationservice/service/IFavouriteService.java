package com.stackroute.matchrecommendationservice.service;

import com.stackroute.matchrecommendationservice.domain.model.Favourite;

public interface IFavouriteService {
	
	public Favourite findByFavouriteMatchId(Integer id);
}
