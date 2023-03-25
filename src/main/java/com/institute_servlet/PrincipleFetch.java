package com.institute_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Institute.Principle;

@WebServlet("/createAccount")
public class PrincipleFetch extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String Email=req.getParameter("email");
	String name = req.getParameter("name");
	String password = req.getParameter("password");
	String phoneNo = req.getParameter("phno");
	String Age=  req.getParameter("age");
	
	long phno1=Long.parseLong(phoneNo);
	int age1=Integer.parseInt(Age);
	
  	Principle p=new Principle();
  	p.setEmail(Email);
  	p.setPassword(password);
  	p.setName(name);
  	p.setPhno(phno1);
  	p.setAge(age1);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("institute");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	 
	  
	et.begin();		em.persist(p);		et.commit();
	
	PrintWriter pw = resp.getWriter();
	pw.write("Account Created");
	resp.setCharacterEncoding("text/html");
	
	RequestDispatcher rd = req.getRequestDispatcher("login.html");
	rd.forward(req, resp);
	resp.setContentType("text/html");
}
}
