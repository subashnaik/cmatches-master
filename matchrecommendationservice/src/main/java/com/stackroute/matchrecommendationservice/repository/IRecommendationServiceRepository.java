package com.stackroute.matchrecommendationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.matchrecommendationservice.domain.model.Recommendation;

@Repository
public interface IRecommendationServiceRepository extends JpaRepository<Recommendation, Integer>{
	
	public Recommendation findByMatchId(Integer matchId);
	
	@Modifying
	@Transactional
	@Query ("UPDATE Recommendation r set r.counter = :counter where r.matchId = :matchId" )
	public int updateByMatchId(@Param("counter") int counter, @Param("matchId") int matchId);
	
}
