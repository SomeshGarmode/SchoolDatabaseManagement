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
@WebServlet("/uteacher")
public class Teacher_Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tid = req.getParameter("tid");
		String tname = req.getParameter("tname");
		String subjects = req.getParameter("subjects");
		String salary = req.getParameter("salary");
		
		int tid1 = Integer.parseInt(tid);
	    long salary1=Long.parseLong(salary);
		
		Teacher t=new Teacher();
		 t.setTid(tid1);t.setTname(tname);t.setSubjects(subjects);t.setSalary(salary1);	
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cshool");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();		em.merge(t);		et.commit();
		
		PrintWriter pw = resp.getWriter();
		pw.write("updated teacher  Data");
		
		RequestDispatcher rd = req.getRequestDispatcher("T_update.html");
		rd.forward(req, resp);
		resp.setContentType("text/html");
	}

}
