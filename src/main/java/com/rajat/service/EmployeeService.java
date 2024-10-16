package com.rajat.service;

import java.util.List;

import com.rajat.entity.Address;
import com.rajat.entity.Employee;

public interface EmployeeService {

	List<Employee> viewAllEmployee();
	
	Employee viewEmployee();

	String updateEmployee(Employee obj);

	String deleteEmployee();

	String saveAddress(Address address);

	void deleteAddress(String _id);

}
