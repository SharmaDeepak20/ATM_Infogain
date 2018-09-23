package com.org.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.bean.Users;
import com.org.dao.DatabaseDaoImpl;

/**
 * Servlet implementation class ShowAllUsersServlet
 */
public class ShowAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShowAllUsersServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		DatabaseDaoImpl dbDao=new DatabaseDaoImpl();
		
		if(session!=null)
		{
			List<Users> usersList=dbDao.showAllUsers();
			session.setAttribute("usersList", usersList);
			RequestDispatcher reqDis=request.getRequestDispatcher("Admin/showAllUsers.jsp");
			reqDis.forward(request, response);
		}
		else
		{
			RequestDispatcher reqDis=request.getRequestDispatcher("Admin.jsp");
			reqDis.forward(request, response);
		}
	}
}
