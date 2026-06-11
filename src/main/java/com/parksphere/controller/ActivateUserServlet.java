package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.UserDAOImpl;
import com.parksphere.daoInterfaces.UserDAO;

@WebServlet("/activate-user")
public class ActivateUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("id"));

		UserDAO dao = new UserDAOImpl();

		dao.activateUser(userId);

		response.sendRedirect("users-list");
	}
}