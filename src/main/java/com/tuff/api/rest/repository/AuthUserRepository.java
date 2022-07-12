package com.tuff.api.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tuff.api.rest.model.AuthUser;


@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, Integer>
{
	public Boolean existsByUsername(String username); 
	public AuthUser findByUsername(String username);
	@Query("{username : ?0,password : ?1}")
	public AuthUser findByUsernameAndPassword(String username,String password);
}
