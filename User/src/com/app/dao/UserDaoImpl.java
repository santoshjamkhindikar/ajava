package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

import org.hibernate.*;

@Repository
public class UserDaoImpl implements UserDao {
	// dependency
	@Autowired // byType
	private SessionFactory sf;

	public UserDaoImpl() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	@Override
	public User validateUser(String email, String pass) {
		String jpql = "select u from users u where u.email=:em and u.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).setParameter("pa", pass)
				.getSingleResult();
	}


}
