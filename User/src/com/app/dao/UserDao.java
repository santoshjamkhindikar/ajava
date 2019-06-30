package com.app.dao;

import com.app.pojos.User;

public interface UserDao {
	User validateUser(String email,String pass);
	
}
