<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Pin</title>
</head>
<body>

   <%
   HttpSession session=request.getSession(false);
       if(session!=null)
       {
    	   int oldPin=Integer.parseInt(request.getParameter("oldPin"));
    	   int newPin=Integer.parseInt(request.getParameter("newPin"));
    	   int confirmPin=Integer.parseInt(request.getParameter("confirmPin"));
    	   int sessionPin=(Integer)session.getAttribute("pinNumber");
    	   
    	   if(newPin==confirmPin)
    	   {
    		    if(oldPin==sessionPin)
    		    {
    		    	String oldPin1=""+oldPin;
    		    	String newPin1=""+newPin;
    		    	String confirmPin1=""+confirmPin;
    		    	
    		    	if(oldPin1.length()==4 && newPin1.length()==4 && confirmPin1.length()==4)
    		    	{
    		    		session.setAttribute("newPin", newPin);
    		    	    response.sendRedirect("../PinChangeServlet");
    		    	}
    		    	else
    		    	{
    		    	   %>
    	      		       <jsp:forward page="index.jsp">
    	      		       <jsp:param value="Pin should be of 4 digits" name="msg"/>
    	      		       </jsp:forward>
    	      		   <%
    		    	}
    		    }
    		    else
    		    {
    		    	 %>
      		       <jsp:forward page="index.jsp">
      		       <jsp:param value="Sorry your pin doesn't exist" name="msg"/>
      		       </jsp:forward>
      		   <%
    		    }
    	   }
    	   else
    	   {
    		   %>
    		       <jsp:forward page="index.jsp">
    		       <jsp:param value="Sorry Pin doesn't matched" name="msg"/>
    		       </jsp:forward>
    		   <%
    	   }
       }
       else
       {
    	   %>
    	     <jsp:forward page="../index.jsp">
    	     <jsp:param value="Please Login first" name="msg"/>
    	     </jsp:forward>
    	   <%
       }
   %>

</body>
</html>