package com.rajat.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rajat.entity.Address;

public interface AddressRepository extends MongoRepository<Address, String>{

	
}
