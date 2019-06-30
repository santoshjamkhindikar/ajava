package com.app.service;

import com.app.pojos.User;

public interface Userservice {
	User validateUser(String email,String pass);
	
}
