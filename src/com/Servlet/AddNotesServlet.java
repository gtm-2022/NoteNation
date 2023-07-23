package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.PostDAO;
import com.Db.DBConnect;
import com.User.Post;


@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {
	
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	int uid=Integer.parseInt(request.getParameter("uid"));
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	
PostDAO dao = null;
try {
	dao = new PostDAO(DBConnect.getConn());
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
boolean f=dao.AddNotes(title, content, uid);
if(f) {
	System.out.println("Data insert sucessfully");
	response.sendRedirect("showNotes.jsp");
	
}
else {
	System.out.println("Data not inserted");
}
		
	}

}
