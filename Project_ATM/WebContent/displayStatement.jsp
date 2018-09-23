<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mini Statement</title>
</head>
<body>

<%
   if(session!=null)
   {
	   String fileName=(String)session.getAttribute("cardNumber");
	   fileName="MiniStatement"+fileName+".txt";
	   %>
	       <center>
	          <h1>Please check file <br><%=fileName %></h1><hr>
	          <a href="homepage.jsp">HOMEPAGE</a>
	       </center>
	   
	   <%
   }
   else
   {
	   response.sendRedirect("index.jsp");
   }
%>
</body>
</html>