package com.org.pinChange;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class PinChangeServlet
 */
public class PinChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PinChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
		
		if(session!=null)
		{
			int newPin=(Integer)session.getAttribute("newPin");
			String cardNumber=(String)session.getAttribute("cardNumber");
			dbDao.pinChange(newPin, cardNumber);
		    session.removeAttribute("newPin");
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
