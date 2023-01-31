package com.school;

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
@WebServlet("/ustudent")
public class SUpdate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String stream = req.getParameter("stream");
		String fees = req.getParameter("fees");
		
		int id1 = Integer.parseInt(id);
		double fees1 = Double.parseDouble(fees);
		
		Student s = new Student();
		s.setId(id1);		s.setName(name);s.setStream(stream);	s.setFees(fees1);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cshool");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();		em.merge(s);		et.commit();
		
		PrintWriter pw = resp.getWriter();
		pw.write("Update the Data");
		
		RequestDispatcher rd = req.getRequestDispatcher("Student.html");
		rd.include(req, resp);
		
		resp.setContentType("text/html");
	}
	
}
/*
 this is a web application which is built on hibernate framework and servlets.
 this application is used to maintain records of students and staff by management 
 * 
 */
 