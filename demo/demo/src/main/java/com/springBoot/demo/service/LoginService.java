package com.springBoot.demo.service;

import com.springBoot.demo.model.Login;

public interface LoginService {

	public String authenticateUser(Login login) throws Exception;
	
}
