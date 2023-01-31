package com.server;

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

import com.school.Principal;

@WebServlet("/Account1")
public class Driverschool extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String phno=req.getParameter("phno");
		String Age=req.getParameter("Age");
       
		int id1=Integer.parseInt(id);
		int Age1=Integer.parseInt(Age);
		Long phno1=Long.parseLong(phno);     

		Principal p=new Principal();
		p.setId(id1);
		p.setName(name);
		p.setEmail(email);
		p.setAge(Age1);
		p.setPhno(phno1);
		p.setPassword(password);

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("cshool");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();


		PrintWriter pw=resp.getWriter();
		pw.write("Account Created");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, resp);
		resp.setContentType("text/html");

	}
}







