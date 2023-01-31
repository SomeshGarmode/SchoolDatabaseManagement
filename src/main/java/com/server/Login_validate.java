package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class Login_validate extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	System.out.println(email);
	System.out.println(password);
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("cshool");
	EntityManager em=emf.createEntityManager();
	
	 Query q=em.createQuery("select p from Principal p where p.email=?1 and p.password=?2");
	
	 q.setParameter(1, email);
	 q.setParameter(2, password);
	 
	List<Principal> p=q.getResultList();

	if(p.size()>0)
	{
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		 pw.write("login succesfully");
		 RequestDispatcher rd=req.getRequestDispatcher("All.html");
		 rd.include(req,resp);
	}
	else
	{resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	 pw.write("Invalid credential");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req,resp);
	}
	}
	 
}

