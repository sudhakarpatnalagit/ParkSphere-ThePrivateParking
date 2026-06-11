package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.UserDAOImpl;
import com.parksphere.daoInterfaces.UserDAO;
import com.parksphere.model.User;

@WebServlet("/update-user")
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		user.setUserId(Integer.parseInt(request.getParameter("userId")));

		user.setFullName(request.getParameter("fullName"));

		user.setEmail(request.getParameter("email"));

		user.setPhone(request.getParameter("phone"));

		user.setPassword(request.getParameter("password"));

		UserDAO dao = new UserDAOImpl();

		dao.updateUser(user);

		response.sendRedirect("users-list");
	}
}