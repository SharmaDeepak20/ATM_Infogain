<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
   <%
       if(session!=null)
       {
    	   double currentBalance=(Double)request.getAttribute("currentBalance");
    	   
    	   %>
    	       <h1>Your Current Balance is ${currentBalance}</h1><hr/>
    	       <a href="homepage.jsp">HOMEPAGE</a>
    	   <%
       }
       else
       {
    	   %>
    	      <jsp:forward page="index.jsp">
    	       <jsp:param value="Please Login first" name="msg"/>
    	      </jsp:forward>
    	   <%
       }
   %>
</center>
</body>
</html>