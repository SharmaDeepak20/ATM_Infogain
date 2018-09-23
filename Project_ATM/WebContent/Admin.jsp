<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
    <form action="Admin/AdminLoginDB.jsp" method="POST">
        <table>
            <tr>
               <td><input type="email" name="adminid" placeholder="abc@gmail.com" required></td>
            </tr>
            
            <tr>
              <td><input type="password" name="password" placeholder="**********" required></td>
            </tr>
            
            <tr>
                <td><input type="submit" value="SUBMIT"></td>
                <td><input type="reset" value="RESET"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>