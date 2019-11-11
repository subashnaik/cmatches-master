package com.stackroute.matchrecommendationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.matchrecommendationservice.domain.model.Favourite;

@Repository
public interface IFavouriteServiceRepository extends JpaRepository<Favourite, Integer>{
	@Query ("SELECT f FROM Favourite f where f.matchId = :macthId" )
	public List<Favourite> findByMatchId(@Param("macthId") Integer matchId);
	
}
