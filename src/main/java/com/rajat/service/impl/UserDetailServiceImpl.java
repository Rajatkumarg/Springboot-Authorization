package com.rajat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rajat.entity.Employee;
import com.rajat.repo.EmployeeRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee e = empRepo.findByUsername(username);
		System.out.println("loadUserByUsername called");
		if (e != null) {
            return User.builder()
                    .username(e.getUsername())
                    .password(e.getPwd())
                    .roles(e.getRoles().toArray(new String[0]))
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    
	}

}
