<%@page import="com.org.dao.DatabaseDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create new user</title>
</head>
<body>

<%
    HttpSession session=request.getSession(false);
    
     
    if(session!=null)
    {
    	%>
    	   <jsp:useBean id="user" class="com.org.bean.Users"/>
    	   <jsp:setProperty property="*" name="user"/>
    	<%
    	
    	DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
    	dbDao.insertUser(user);
    	%>
    	   <jsp:forward page="../Admin/index.jsp">
    	   <jsp:param value="user Created Successfully" name="msg"/>
    	   </jsp:forward>
    	<%
    }
    else
    {
    	response.sendRedirect("../Admin.jsp");
    }
%>
</body>
</html>