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

import com.Institute.Student;
@WebServlet("/s_delete")
public class Student_Delete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String id = req.getParameter("id");
	String name = req.getParameter("name");
	
	
	int id1 = Integer.parseInt(id);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("institute");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Student s =em.find(Student.class, id1);
	
	et.begin();		em.remove(s);		et.commit();
	
	PrintWriter pw = resp.getWriter();
	pw.write("Deleted Data");
	
	RequestDispatcher rd = req.getRequestDispatcher("Student.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
}
}
