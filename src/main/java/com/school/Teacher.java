package com.school;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
	private int tid;
	private  String tname;
	private String subjects;
	private long salary;


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}




	public String getSubjects() {
		return subjects;
	}


	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}

	
	
}
