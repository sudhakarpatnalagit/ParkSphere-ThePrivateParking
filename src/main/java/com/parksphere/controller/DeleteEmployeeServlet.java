package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.EmployeeDAOImpl;
import com.parksphere.daoInterfaces.EmployeeDAO;

@WebServlet("/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int employeeId = Integer.parseInt(request.getParameter("id"));

		EmployeeDAO dao = new EmployeeDAOImpl();

		dao.deleteEmployee(employeeId);

		response.sendRedirect("employees-list");
	}
}