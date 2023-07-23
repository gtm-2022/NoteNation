package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("umail");
		String password=request.getParameter("upassword");
		
		UserDetails us=new UserDetails();
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao = null;
		try {
			dao = new UserDAO(DBConnect.getConn());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDetails user=dao.loginUser(us);
		if(user!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("userD", user);
			
			
			response.sendRedirect("home.jsp");
			
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("login-failed","Invalid Username and Password");
			response.sendRedirect("login.jsp");
		}
	}

}
