package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parksphere.dao.AdminDAOImpl;
import com.parksphere.dao.EmployeeDAOImpl;
import com.parksphere.dao.UserDAOImpl;
import com.parksphere.daoInterfaces.AdminDAO;
import com.parksphere.daoInterfaces.EmployeeDAO;
import com.parksphere.daoInterfaces.UserDAO;
import com.parksphere.model.Admin;
import com.parksphere.model.Employee;
import com.parksphere.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		String role = request.getParameter("role");

		HttpSession session = request.getSession();

		try {

			if ("USER".equals(role)) {

				UserDAO userDAO = new UserDAOImpl();

				User user = userDAO.login(email, password);

				if (user != null) {

					session.setAttribute("user", user);

					response.sendRedirect("user-dashboard.jsp");

					return;
				}
			}

			else if ("EMPLOYEE".equals(role)) {

				EmployeeDAO employeeDAO = new EmployeeDAOImpl();

				Employee employee = employeeDAO.login(email, password);

				if (employee != null) {

					session.setAttribute("employee", employee);

					response.sendRedirect("employee-dashboard.jsp");

					return;
				}
			}

			else if ("ADMIN".equals(role)) {

				AdminDAO adminDAO = new AdminDAOImpl();

				Admin admin = adminDAO.login(email, password);

				if (admin != null) {

					session.setAttribute("role", "ADMIN");

					session.setAttribute("admin", admin);

					response.sendRedirect("admin-dashboard.jsp");

					return;
				}
			}

			response.sendRedirect("login.jsp?error=1");

		} catch (Exception e) {

			e.printStackTrace();

			response.sendRedirect("login.jsp?error=1");
		}
	}
}