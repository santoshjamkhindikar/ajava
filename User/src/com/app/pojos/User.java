package com.app.pojos;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="users")
public class User {
	private Integer id;
	private String name,email,password;

	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String email, String password, String role, String city, String phoneNo,
			double regAmount, Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	

}
