<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="com.Institute.Teacher"%>

<%@page import="javax.persistence.Persistence"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Fetch</title>
</head>
<body>
<h1>Teacher details fetch</h1>
<%
	List<Teacher>tl=(List)session.getAttribute("tlist");
  
	%>
	<table align="center" cellpadding="20px" border="1">
	<th>tid</th>
	<th>salary</th>
	<th>subject</th>
	<th>tname</th>
<%for(Teacher t:tl){ %>	
<tr>
<td><%=t.getTid() %></td>
<td><%=t.getSalary() %></td>
<td><%=t.getSubjects() %></td>
<td><%=t.getTname() %></td>
</tr>
<%} %>
	</table>

</body>
</html>