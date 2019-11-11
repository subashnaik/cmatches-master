package com.stackroute.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.userservice.domain.model.User;

@Repository
public interface IUserServiceRepository extends JpaRepository<User, String> {
	
	 User findByUserIdAndUserPassword(String userId, String userPassword);
}
