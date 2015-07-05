package com.loginpage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.loginpage.model.LoginPage;
import com.loginpage.service.ILoginPageService;
import com.loginpage.service.LoginPageServiceImpl;

public class LoginPageServlet extends HttpServlet {
	LoginPage loginPageObject = new LoginPage();
	ILoginPageService loginPageServiceObject = new LoginPageServiceImpl();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("uname");
		String password = request.getParameter("passwd");

		loginPageObject.setUserName(userName);
		loginPageObject.setPassword(password);

		boolean login = loginPageServiceObject.checkValidation(loginPageObject);

		if (login) {
			loginPageServiceObject.addUser(loginPageObject);
			response.sendRedirect("html/welcome.html");

		} else {
			out.println("<h3 style=color:blue>Invalid User Name and Password</h3>");
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("html/index.html");
			requestDispatcher.include(request, response);

		}

	}
}
