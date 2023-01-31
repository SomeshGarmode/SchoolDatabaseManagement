<%@page import="com.school.Student"%>
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
<%
	String id = request.getParameter("id");
	
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("cshool");
	EntityManager em=emf.createEntityManager();
	
	Student s1=em.find(Student.class,id);	
	%>

	<form action="ustudent" method="post">
		id: <input type="text" value="<%=s1.getId()%>" name="id">
		name: <input type="text" value="<%=s1.getName()%>" name="name">
		Stream:<input type="text" value="<%=s1.getStream() %>"name="stream">
		
		Fees: <input type="text" value="<%=s1.getFees()%>"name="fees">
		<input type="submit">
</body>
</html>