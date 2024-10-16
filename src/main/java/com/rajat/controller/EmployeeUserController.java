package com.rajat.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoWriteException;
import com.rajat.entity.Employee;
import com.rajat.repo.EmployeeRepository;

@RestController
@RequestMapping("/employeeUser")
public class EmployeeUserController {

	private PasswordEncoder passswordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
    EmployeeRepository repo;
	
	 @PostMapping("/save")
	 public Employee saveEmployee(@RequestBody Employee emp) {
    	String pwd = passswordEncoder.encode(emp.getPwd());
    	emp.setPwd(pwd);
    	try {
    		return repo.save(emp);
    	}catch(Exception e) {
    		System.out.println("It seems trying entering duplicate username");
    		return null;
    	}
    }
}
