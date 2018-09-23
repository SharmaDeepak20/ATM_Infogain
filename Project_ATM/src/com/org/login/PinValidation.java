package com.org.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PinValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PinValidation() {
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		
		if(session!=null){
		String pinNo=request.getParameter("pinNumber");
		int count=0;
		char pinNumber[]=pinNo.toCharArray();
		for(char a:pinNumber)
		{
			if(a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9')
			{
				count=0;
			}
			else
			{
				count=1;
				break;
			}
		}//end forEach
		
		if(count==1)
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("pinvalidation.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			Integer pinNumber1=(Integer)(session.getAttribute("pinNumber"));
			if(pinNumber1==Integer.parseInt(pinNo))
			{
				RequestDispatcher reqDis=request.getRequestDispatcher("homepage.jsp");
				reqDis.forward(request, response);
			}
			else
			{
				RequestDispatcher reqDis=request.getRequestDispatcher("pinvalidation.jsp");
				reqDis.forward(request, response);
			}
		}
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}//end doPost

}
