package com.institute_servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Institute.Teacher;


@WebServlet("/tfetch")
public class Teacher_Fetch {

	private void dopost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("institute");
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et=em.getTransaction();
	
	    
     Query q=em.createQuery("select t from Teacher t ");
       List<Teacher> tli=q.getResultList();
     
		HttpSession hs=req.getSession();
		hs.setAttribute("tlist",tli);
			
			RequestDispatcher rd = req.getRequestDispatcher("Teacher_fetch.jsp");
			rd.forward(req, resp);
			resp.setContentType("text/html");
		
}
}
