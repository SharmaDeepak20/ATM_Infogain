<%@page import="com.org.bean.Admin"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.DatabaseDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="admin1" class="com.org.bean.Admin"/>
    <jsp:setProperty property="adminid" name="admin1"/>
    <jsp:setProperty property="password" name="admin1"/>
    
    <%
       HttpSession session=request.getSession();
       DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
       List<Admin> adminList=dbDao.loginAdmin(admin1);
       session.setAttribute("adminid", adminList.get(0).getAdminid());
       session.setAttribute("name", adminList.get(0).getName());
       
       response.sendRedirect("index.jsp");
    %>
    
</body>
</html>