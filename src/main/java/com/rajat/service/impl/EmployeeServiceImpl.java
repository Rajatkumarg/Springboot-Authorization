package com.rajat.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.rajat.entity.Address;
import com.rajat.entity.Employee;
import com.rajat.repo.AddressRepository;
import com.rajat.repo.EmployeeRepository;
import com.rajat.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
    EmployeeRepository empRepo;
	
	@Autowired
	AddressRepository addressRepo;

	//For Employee With Admin Credentials
	
    @Override
    public List<Employee> viewAllEmployee() {
        return empRepo.findAll();
    }
    
    
    //For Employee with Non Admin Credential
    
    @Override
    public Employee viewEmployee() {
    	Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        return empRepo.findByUsername(auth.getName());
    }

	@Override
	public String updateEmployee(Employee obj) {
    	Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
    	String username = auth.getName();
    	Employee e = empRepo.findByUsername(username);
    	if(e!=null) {
    		e.setName(obj.getName());
    		e.setUsername(obj.getUsername());
    		e.setPwd(new BCryptPasswordEncoder().encode(obj.getPwd()));
    		List<Address> dbAddresses = e.getAddress();
			if (obj.getAddress() != null && !obj.getAddress().isEmpty()) {
				if (dbAddresses == null || dbAddresses.isEmpty()) {
					e.setAddress(obj.getAddress());
				} else {
					dbAddresses.addAll(obj.getAddress());
					e.setAddress(dbAddresses);
				}
				addressRepo.saveAll(obj.getAddress());
			}
    		empRepo.save(e);
    		return e.getUsername()+" updated successfully";
    	}
    	return "Updation not happened";
	}

	@Override
	public String deleteEmployee() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Employee e = empRepo.findByUsername(username);
		if(e!=null) {
			List<Address> list = e.getAddress();
			if(list!=null && !list.isEmpty()) {
				for(Address address: list) {
					String id = address.get_id();
					addressRepo.deleteById(id);
				}
			}
			empRepo.delete(e);
			return username+" Deleted successfully";
		}
		return "No employee found with username "+username;
	}

	//For Address
	
	@Override
	public String saveAddress(Address address) {
		String username =SecurityContextHolder.getContext().getAuthentication().getName();
		addressRepo.save(address);
		Employee e = empRepo.findByUsername(username);
		List<Address> addresses = e.getAddress();
		if(addresses==null || addresses.isEmpty()) {
			addresses = Arrays.asList(address);
		}else {
			addresses.add(address);
		}
		e.setAddress(addresses);
		empRepo.save(e);
		return "Address saved";
	}


	@Override
	public void deleteAddress(String _id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Employee emp = empRepo.findByUsername(username);
		List<Address> addresses = emp.getAddress();
		if(addresses!=null && !addresses.isEmpty()) {
//			addresses = addresses.stream().filter(add->!(add.get_id().equals(_id))).collect(Collectors.toList());
			if(addresses.removeIf(address->address.get_id().equals(_id))){
				empRepo.save(emp);
				addressRepo.deleteById(_id);
			}
		}
	}
    
}
