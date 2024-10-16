package com.rajat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.entity.Employee;
import com.rajat.service.impl.UserDetailServiceImpl;
import com.rajat.util.JWTUtil;

@RestController
@RequestMapping("/public")
public class PublicController {

	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
    JWTUtil jwtUtil;
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Employee emp) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(emp.getUsername(), emp.getPwd()));
            System.out.println("----------First Auth done");
            UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(emp.getUsername());
            System.out.println("----------Second Auth done");
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            System.out.println("----------Third Auth done"+jwt);
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Exception occurred while createAuthenticationToken "+ e);
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }
    }
}
