<%@page import="com.Institute.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
   String id=request.getParameter("tid"); 
   String salary=request.getParameter("salary");
		   int id1 = Integer.parseInt(id);	
		  // Double salary1=Double.parseDouble(salary);
		
		   
   EntityManagerFactory emf=Persistence.createEntityManagerFactory("institute");
 //  EntityManager em=emf.createEntityManager();
   EntityManager em=emf.createEntityManager();
	Teacher t=em.find(Teacher.class,id1);	
	%>

	<form action="tupdate" method="post">
	<center><h2>update student Data</h2></center>
		id: <input type="number" value="<%=t.getTid()%>" name="tid"><br><br>
		name: <input type="text" value="<%=t.getTname()%>" name="tname"><br><br>
		subjects:<input type="text" value="<%=t.getSubjects()%>"name="subjects"><br><br>	
		Salary:<inpuut type="number" value="<%=t.getSalary() %>" name="salary">
	<br><br>
		<input type="submit">
</body>
</html>