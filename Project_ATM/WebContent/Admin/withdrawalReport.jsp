<%@page import="com.org.bean.Transaction1"%>
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
   List<Transaction1> transList=(List<Transaction1>)session.getAttribute("transList");
%>
<div class="container">
<center>
  <h2>Today's Withdrawal Report</h2><hr/>
</center>           
  <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>AMOUNT</th>
        <th>CARD NUMBER</th>
        <th>DATE</th>
      </tr>
    </thead>
    <tbody>
    <%
        for(Transaction1 trans:transList)
        {
        	%>
        	<tr>
             <td><%=trans.getAmount()%></td>
             <td><%=trans.getCardNumber()%></td>
             <td><%=trans.getDate()%></td>
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