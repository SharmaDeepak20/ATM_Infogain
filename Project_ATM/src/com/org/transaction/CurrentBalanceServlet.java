package com.org.transaction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class CurrentBalanceServlet
 */
public class CurrentBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CurrentBalanceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		double amount=0.0;
		if(session!=null)
		{
			String cardNumber=(String)session.getAttribute("cardNumber");
			DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
			amount=dbDao.currentBalance(cardNumber);
			request.setAttribute("currentBalance", amount);
			
			try{
				File file=new File("currentBalance"+cardNumber);
				FileOutputStream fos=new FileOutputStream(file);
				PrintWriter pw=new PrintWriter(fos);
				pw.write("Current Balance of cardNumber "+cardNumber+" is "+amount);
				pw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			RequestDispatcher reqDis=request.getRequestDispatcher("displayCurrentBalance.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}
}
