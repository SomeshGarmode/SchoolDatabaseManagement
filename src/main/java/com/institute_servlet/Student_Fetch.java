package com.institute_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Institute.Student;


@WebServlet("/stdfetch")
public class Student_Fetch extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");	
		String fees=req.getParameter("fees");
	int id1 = Integer.parseInt(id);
	 double fees1=Double.parseDouble(fees);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("institute");
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et=em.getTransaction();
	
     Query q=em.createQuery("select s from Student s ");
       List<Student> li=q.getResultList();
     
		HttpSession hs=req.getSession();
		hs.setAttribute("stdlist", li);
			
			RequestDispatcher rd = req.getRequestDispatcher("Student_fetch.jsp");
			rd.forward(req, resp);
			resp.setContentType("text/html");
		}
	

}
