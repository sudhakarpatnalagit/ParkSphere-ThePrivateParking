package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.UserDAOImpl;
import com.parksphere.daoInterfaces.UserDAO;
import com.parksphere.model.User;

@WebServlet("/edit-user")
public class EditUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("id"));

		UserDAO dao = new UserDAOImpl();

		User user = dao.getUserById(userId);

		request.setAttribute("user", user);

		request.getRequestDispatcher("edit-user.jsp").forward(request, response);
	}
}