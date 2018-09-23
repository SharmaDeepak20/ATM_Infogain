<%@page import="com.org.bean.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" isELIgnored="false"%>

    
    	   <!DOCTYPE html>
<html lang="en">
<head>
  <title>All Users</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<%
HttpSession session=request.getSession();
 if(session!=null)
 {
    List<Users> usersList=(List<Users>)session.getAttribute("usersList");
    System.out.println(usersList);
%>
<div class="container">
<center>
  <h2>All Users</h2><hr/>
</center>           
  <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>NAME</th>
        <th>CARD NUMBER</th>
        <th>GENDER</th>
        <th>ADDRESS</th>
        <th>PHONE NUMBER</th>
        <th>BALANCE</th>
        <th>STATUS</th>
      </tr>
    </thead>
    <tbody>
    <%
        for(Users users:usersList)
        {
        	%>
        	<tr>
             <td><%=users.getUsername() %></td>
             <td><%=users.getAccountNo() %></td>
             <td><%=users.getGender() %></td>
             <td><%=users.getAddress() %></td>
             <td><%=users.getPhoneNumber() %></td>
             <td><%=users.getBalance()%></td>
             <td><%=users.getStatus() %></td>
            </tr>
        	<%
        }//end forEach
    %>
    </tbody>
  </table>
</div>

</body>
</html>
    	   
    	   <%
       }
       else
       {
    	   response.sendRedirect("../Admin.jsp");
       }
    %>