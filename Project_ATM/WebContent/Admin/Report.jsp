<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.org.bean.Transaction1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession session=request.getSession(false);

if(session!=null)
{
	List<Transaction1> transList=(List<Transaction1>)session.getAttribute("transList");
	File file=new File("Report.pdf");
	FileOutputStream fos=new FileOutputStream(file);
	PrintWriter pw=new PrintWriter(fos);
	
	for(Transaction1 trans:transList)
	{
		pw.write("["+trans.getAmount()+"] ["+trans.getCardNumber()+"] ["+trans.getDate()+"] ["+trans.getStatus()+"]");
	}
	pw.close();
	
	RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
	reqDis.forward(request, response);
}
else
{
	RequestDispatcher reqDis=request.getRequestDispatcher("../Admin.jsp");
	reqDis.forward(request, response);
}
%>
</body>
</html>