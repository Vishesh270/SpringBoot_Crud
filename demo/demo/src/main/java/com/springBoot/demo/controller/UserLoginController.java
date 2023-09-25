package com.springBoot.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.model.Login;
import com.springBoot.demo.service.LoginService;
@RestController
@RequestMapping("/login")
public class UserLoginController {
	@Autowired
	private LoginService loginser;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/user")
	public ResponseEntity<String> loginAPI(@RequestBody Login login) throws Exception{
		
		
		try {
			
			String message=loginser.authenticateUser(login);
			System.out.println(message);
			return new ResponseEntity<String>(message,HttpStatus.OK);
			
			
		}
		catch(Exception e) {
			String message="Unsuccessfull Login Bad Credentials";
			return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
	}
}
