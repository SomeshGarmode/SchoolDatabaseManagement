package com.Institute;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Principle {
	
//	private int id ;      //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name;
	@Id
	private String email;
	private String password;
	private long phno;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
