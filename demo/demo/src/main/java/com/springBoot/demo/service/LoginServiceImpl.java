package com.springBoot.demo.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.demo.dao.UsersDao;
import com.springBoot.demo.model.Login;
import com.springBoot.demo.model.Users;

import jakarta.transaction.Transactional;
@Service(value="LoginService")
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UsersDao userdao;
	
	@Override
	public String authenticateUser(Login login) throws Exception{
		Users user= userdao.authenticateUsers(login.getUsername());
		if(login.getPassword().equals(user.getPassword())) {
			
			if(user.getStatus().equals("active")) {
				return ("Login Succefull "+"Login with "+user.getUsername()+" logged as "+user.getRole());
			}
			else {
				throw new Exception("service.user_is_deactivated");
			}
			
		}
		else {
			throw new Exception("service.user_creds_not_matched");
		}
	}

}
