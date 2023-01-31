<%@page import="com.school.Teacher"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManager"%>
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
	String id = request.getParameter("tid");
	
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("cshool");
	EntityManager em=emf.createEntityManager();
	
	Teacher t1=em.find(Teacher.class, id1);	
	%>

	<form action="uteacher" method="post">
		id: <input type="text" value="<%=t1.getTid()%>" name="tid">
		name: <input type="text" value="<%=t1.getTname()%>" name="tname">
		salary: <input type="text" value="<%=t1.getSalary()%>" name="salary">
		subject: <input type="text" value="<%=t1.getSubjects()%>"name="subjects">
		<input type="submit">
	</form>
</body>
</html>