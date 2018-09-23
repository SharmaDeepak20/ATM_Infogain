package com.org.withdrawal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class WithdrawalMoneyServlet
 */
public class WithdrawalMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WithdrawalMoneyServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession(false);
		
		if(session!=null)
		{
			String cardNumber=request.getParameter("cardNumber");
			double amount=Double.parseDouble(request.getParameter("withdrawalAmount"));
			DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
			dbDao.withdrawalMoney(cardNumber, amount);
			response.sendRedirect("homepage.jsp");
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}

}
