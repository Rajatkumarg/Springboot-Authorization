package com.rajat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.entity.Employee;
import com.rajat.service.EmployeeService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/viewAllEmployee")
	public List<Employee> viewAllEmployee() {
		List<Employee> list = service.viewAllEmployee();
        System.out.println(list);
        return list;
	}
}
