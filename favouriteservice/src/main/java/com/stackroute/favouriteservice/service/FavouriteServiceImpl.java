package com.stackroute.favouriteservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favouriteservice.domain.model.Favourite;
import com.stackroute.favouriteservice.repository.IFavouriteServiceRepository;

@Service
public class FavouriteServiceImpl implements IFavouriteService{

	@Autowired
	private IFavouriteServiceRepository favouriteRepository;
	
	public FavouriteServiceImpl(IFavouriteServiceRepository favouriteRepository) {
		this.favouriteRepository = favouriteRepository;
	}
	
	@Override
	public Favourite findByFavouriteMatchId(String userId, Integer id) {
		return favouriteRepository.findByUserIdAndMatchId(userId, id);
	}

	@Override
	public Favourite addFavouriteMatch(Favourite favourite) {
		return favouriteRepository.save(favourite);
	}

	@Override
	public void deleteFavouriteMatch(Favourite favourite) {
		favouriteRepository.delete(favourite);
	}

	@Override
	public List<Favourite> getAllFavouriteMatches(String userId) {
		return favouriteRepository.findAllFavouriteMatchesByUserId(userId);
	}

}
