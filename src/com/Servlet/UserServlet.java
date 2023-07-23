package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("fname");
        String email = request.getParameter("usermail");
        String password = request.getParameter("password");

        UserDetails us = new UserDetails();
        us.setName(name);
        us.setEmail(email);
        us.setPassword(password);

        UserDAO dao = null;
        try {
            dao = new UserDAO(DBConnect.getConn());
            boolean f = dao.addUser(us);
            PrintWriter out = response.getWriter();
            HttpSession session;

            if (f) {
                session=request.getSession();
                session.setAttribute("reg-sucess","Registration Sucessfully ..");
                response.sendRedirect("register.jsp");
            } else {
                session=request.getSession();
                session.setAttribute("failed-msg","Something went on server");
                response.sendRedirect("register.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "I/O Error");
        }
    }
}
