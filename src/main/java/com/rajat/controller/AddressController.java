package com.rajat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.entity.Address;
import com.rajat.service.EmployeeService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/saveAddress")
	public String saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}
	
	@DeleteMapping("/deleteAddress/{_id}")
	public void deleteAddress(@PathVariable String _id) {
		 service.deleteAddress(_id);
	}
}
