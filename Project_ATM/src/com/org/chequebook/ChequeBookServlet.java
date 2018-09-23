package com.org.chequebook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class ChequeBookServlet
 */
public class ChequeBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ChequeBookServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		if(session!=null)
		{
			String cardNumber=(String)session.getAttribute("cardNumber");
			DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
			if(dbDao.chequeBookRequest(cardNumber))
			{
				System.out.println("Request Inserted");
				RequestDispatcher reqDis=request.getRequestDispatcher("homepage.jsp");
				reqDis.forward(request, response);
			}
			else
			{
				System.out.println("Request NOt Inserted");
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
