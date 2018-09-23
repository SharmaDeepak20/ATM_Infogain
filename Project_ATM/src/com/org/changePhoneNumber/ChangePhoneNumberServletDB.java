package com.org.changePhoneNumber;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class ChangePhoneNumberServletDB
 */
public class ChangePhoneNumberServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePhoneNumberServletDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
		
		if(session!=null)
		{
			String cardNumber=(String)session.getAttribute("cardNumber");
			String phoneNumber=request.getParameter("newNumber");
			if(phoneNumber.length()==10)
			{
				dbDao.changePhoneNumber(cardNumber, phoneNumber);
				
				RequestDispatcher reqDis=request.getRequestDispatcher("homepage.jsp");
				reqDis.forward(request, response);
			}
			else
			{
				RequestDispatcher reqDis=request.getRequestDispatcher("homepage.jsp");
				reqDis.forward(request, response);
			}
			
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}

}
