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
String n=(String)session.getAttribute("name"); 
if(n==null || n=="" || n.equals("") || n.equals(null)){
	
	response.sendRedirect("index.jsp");
}else{
%>
Success

<a href="/Login/Logout.jsp">Logout</a>
<br/>
<% 

out.print(n);
	
}

%>
</body>
</html>