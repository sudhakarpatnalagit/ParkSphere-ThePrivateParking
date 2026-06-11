package com.parksphere.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.UserDAOImpl;
import com.parksphere.daoInterfaces.UserDAO;
import com.parksphere.model.User;

@WebServlet("/users-list")
public class UsersListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO dao = new UserDAOImpl();

		List<User> users = dao.getAllUsers();

		request.setAttribute("users", users);

		request.getRequestDispatcher("users.jsp").forward(request, response);
	}
}