package com.org.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.bean.Transaction1;

/**
 * Servlet implementation class ReportServlet
 */
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		if(session!=null)
		{
			List<Transaction1> transList=(List<Transaction1>)session.getAttribute("transList");
			File file=new File("Report.pdf");
			FileOutputStream fos=new FileOutputStream(file);
			PrintWriter pw=new PrintWriter(fos);
			
			for(Transaction1 trans:transList)
			{
				pw.write("["+trans.getAmount()+"] ["+trans.getCardNumber()+"] ["+trans.getDate()+"] ["+trans.getStatus()+"]");
			}
			pw.close();
			
			RequestDispatcher reqDis=request.getRequestDispatcher("Admin/index.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("Admin.jsp");
			reqDis.forward(request, response);
		}
		
	}

}
