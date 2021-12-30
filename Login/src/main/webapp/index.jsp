<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
%>
	<a href="/Login/Con">Add</a>
	<form action="/Login/Con" method="post">
	 Name <input type="text" name="name"><br><br>
	 Pass <input type="text" name="pass"><br><br>
	 <input type="submit" value="Login">
	</form>
<%
}else{
	response.sendRedirect("Success.jsp");
}
%>




</body>
</html>