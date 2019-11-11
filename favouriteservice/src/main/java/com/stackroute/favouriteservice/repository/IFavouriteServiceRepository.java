package com.stackroute.favouriteservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.favouriteservice.domain.model.Favourite;

@Repository
public interface IFavouriteServiceRepository extends JpaRepository<Favourite, Integer>{
	@Query ("SELECT f FROM Favourite f where f.matchId = :macthId and f.userId = :userId" )
	public Favourite findByUserIdAndMatchId(@Param("userId") String userId, @Param("macthId") Integer macthId);
	
	@Query ("SELECT f FROM Favourite f where f.userId = :userId" )
	public List<Favourite> findAllFavouriteMatchesByUserId(@Param("userId") String userId);
	
}
