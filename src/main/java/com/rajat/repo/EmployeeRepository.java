package com.rajat.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rajat.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

	@Query("{username:?0}")
	Employee findByUsername(String username);

}
