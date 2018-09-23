package com.org.reports;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.bean.Transaction1;
import com.org.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class TransactionReportServlet
 */
public class TransactionReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TransactionReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
		if(session!=null)
		{
			List<Transaction1> transList=dbDao.transactionReport();
			session.setAttribute("transList", transList);
			
			RequestDispatcher reqDis=request.getRequestDispatcher("Admin/TransactionReport.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("index.jsp");
			reqDis.forward(request, response);
		}
	}

}
