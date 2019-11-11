package com.stackroute.favouriteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.favouriteservice.domain.model.User;

@Repository
public interface IUserServiceRepository extends JpaRepository<User, String> {
	
	 User findByUserId(String userId);
}
