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
@WebServlet("/delete")
public class SDelete extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	String name = req.getParameter("name");
	
	
	int id1 = Integer.parseInt(id);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("cshool");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Student s =em.find(Student.class, id1);
	
	et.begin();		em.remove(s);		et.commit();
	
	PrintWriter pw = resp.getWriter();
	pw.write("Deleted Data");
	
	RequestDispatcher rd = req.getRequestDispatcher("Student.html");
	rd.forward(req, resp);
	
}
}
