package com.stackroute.matchrecommendationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.matchrecommendationservice.domain.model.Favourite;
import com.stackroute.matchrecommendationservice.repository.IFavouriteServiceRepository;

@Service
public class FavouriteServiceImpl implements IFavouriteService{

	@Autowired
	private IFavouriteServiceRepository favouriteRepository;
	
	public FavouriteServiceImpl(IFavouriteServiceRepository favouriteRepository) {
		this.favouriteRepository = favouriteRepository;
	}
	
	@Override
	public Favourite findByFavouriteMatchId(Integer id) {
		List<Favourite> favouries = favouriteRepository.findByMatchId(id);
		if (favouries != null && favouries.size() != 0) {
			return favouries.get(0);
		}
		return null;
	}

}
