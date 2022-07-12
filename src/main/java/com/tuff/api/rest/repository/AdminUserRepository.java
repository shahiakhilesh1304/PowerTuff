package com.tuff.api.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tuff.api.rest.model.AdminUser;

@Repository
public interface AdminUserRepository extends MongoRepository<AdminUser, Integer>
{
	@Query("{'phone':?0}")
	AdminUser findByPhone(String phone);
	@Query("{'email':?0}")
	AdminUser findByEmail(String email);
	@Query("{'user_id':?0}")
	AdminUser findByUserId(String username);
	@Query("{'user_id' : ?0 ,'password' : ?1 }")
	AdminUser findByUserIdAndPassword(String username,String password);
}
