package com.muaz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		if (LoginDao.login(username, password)) {
			//Cookie ck = new Cookie("username", username);
			//response.addCookie(ck);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			out.println("Login Successfull......");
			rd = request.getRequestDispatcher("/welcome.html");
			rd.include(request, response);
		}else{
			out.println("Please enter valid username/password");
			rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
	}

}
