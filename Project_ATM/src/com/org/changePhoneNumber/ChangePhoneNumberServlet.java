package com.org.changePhoneNumber;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePhoneNumber
 */
public class ChangePhoneNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ChangePhoneNumberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		if(session!=null)
		{
			int otp=(int)(Math.random()*10000);
			if(otp==0)
			{
				session.setAttribute("otp", "0000");
			}
			else {
				session.setAttribute("otp", ""+otp);
			}
			RequestDispatcher reqDis=request.getRequestDispatcher("homepage.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}
}
