<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="com.Institute.Student"%>

<%@page import="javax.persistence.Persistence"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Student details fetch</h1>
<%
	List<Student>al=(List)session.getAttribute("stdlist");
  
	%>
	<table align="center" cellpadding="20px" border="1">
	<th>id</th>
	<th>name</th>
	<th>stream</th>
	<th>fees</th>
<%for(Student s:al){ %>	
<tr>
<td><%=s.getId() %></td>
<td><%=s.getName() %></td>
<td><%=s.getStream() %></td>
<td><%=s.getFees() %></td>
</tr>
<%} %>
	</table>

</body>
</html>