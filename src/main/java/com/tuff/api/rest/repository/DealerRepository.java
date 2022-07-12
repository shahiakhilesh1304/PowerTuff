package com.tuff.api.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tuff.api.rest.model.Dealer;

@Repository
public interface DealerRepository extends MongoRepository<Dealer, Integer> 
{
	@Query("{'phone' : ?0}")
	Dealer findByPhone(String phone);
	@Query("{'dealer_code' : ?0}")
	Dealer findByDealerCode(String dealercode);
//	@Query("{}")
//	Dealer findByEmail(String email);
}
