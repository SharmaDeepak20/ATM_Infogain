package com.org.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.bean.Users;
import com.org.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String cardNumber=request.getParameter("cardNumber");
		DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
		
		Users users=dbDao.verifyCardNumber(cardNumber);
		
		if(users!=null)
		{
			session.setAttribute("cardNumber", users.getAccountNo());
			session.setAttribute("pinNumber", users.getPinNo());
			session.setAttribute("username", users.getUsername());
			session.setAttribute("contact", users.getPhoneNumber());
			session.setAttribute("balance", users.getBalance());
			session.setAttribute("status", users.getStatus());
			
			RequestDispatcher reqDis=request.getRequestDispatcher("pinvalidation.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}

}
