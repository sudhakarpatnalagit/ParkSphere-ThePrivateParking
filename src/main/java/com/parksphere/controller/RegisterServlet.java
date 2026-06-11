package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parksphere.dao.UserDAOImpl;
import com.parksphere.daoInterfaces.UserDAO;
import com.parksphere.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		user.setFullName(request.getParameter("fullName"));

		user.setEmail(request.getParameter("email"));

		user.setPhone(request.getParameter("phone"));

		user.setPassword(request.getParameter("password"));

		UserDAO userDAO = new UserDAOImpl();

		boolean success = userDAO.registerUser(user);

		if (success) {

			response.sendRedirect("login.jsp?registered=1");
		}

		else {

			response.sendRedirect("register.jsp?error=1");
		}
	}
}
