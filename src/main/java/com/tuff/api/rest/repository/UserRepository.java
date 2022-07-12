package com.tuff.api.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tuff.api.rest.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> 
{
	public Boolean existsByPhone(String phone);
	public Boolean existsByUsername(String username);
	public User findByPhone(String phone);
	public User findByUsername(String username);
}
