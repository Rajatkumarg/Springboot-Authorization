package com.rajat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.entity.Employee;
import com.rajat.repo.EmployeeRepository;
import com.rajat.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("/viewEmployee")
    public Employee viewEmployee(){
        return service.viewEmployee();
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee obj){
    	String resp = service.updateEmployee(obj);
        return new ResponseEntity<>(resp,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<String> deleteEmployee(){
    	String resp = service.deleteEmployee();
        return new ResponseEntity<>(resp,HttpStatus.ACCEPTED);
    }
}
