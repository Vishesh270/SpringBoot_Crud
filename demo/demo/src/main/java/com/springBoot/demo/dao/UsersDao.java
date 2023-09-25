package com.springBoot.demo.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBoot.demo.entity.UserEntity;
import com.springBoot.demo.model.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class UsersDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Users authenticateUsers(String username) throws Exception{
		
		
		Query query= entityManager.createQuery("select a from UserEntity a where a.username=:name");
		
		query.setParameter("name", username);
		
		List<UserEntity> userEntity  =query.getResultList();
		
		if(!userEntity.isEmpty()) {
			
			Users user =new Users();
			user.setId(userEntity.get(0).getId());
			user.setPassword(userEntity.get(0).getPassword());
			user.setRole(userEntity.get(0).getRole());
			user.setStatus(userEntity.get(0).getStatus());
			user.setUsername(userEntity.get(0).getUsername());
				
			return user;
	
		}
		else {
			throw new Exception("DAO.user_notExist");
		}
		
		
		
	}
	
	
}
