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

import com.Institute.Teacher;
@WebServlet("/tdelete")
public class Teacher_Delete extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String tid = req.getParameter("tid");

	
	int tid1 = Integer.parseInt(tid);  
    
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("institute");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	 
	 Teacher t=em.find(Teacher.class, tid1);
	et.begin();		em.remove(t);		et.commit();
	
	PrintWriter pw = resp.getWriter();
	pw.write("Teacher Data Deleted ");
	
	RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");
	rd.forward(req, resp);
	resp.setContentType("text/html");
}
}
