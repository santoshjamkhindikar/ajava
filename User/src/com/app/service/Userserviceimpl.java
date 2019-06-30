package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.pojos.User;

@Service //to tell SC that this comp contains B.L
@Transactional //to automate tx management
public class Userserviceimpl implements Userservice {
	//dependency
	@Autowired
	private UserDao dao;
	
	@Override
	public User validateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return dao.validateUser(email, pass);
	}

	
}
