package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.EmployeeDAOImpl;
import com.parksphere.daoInterfaces.EmployeeDAO;
import com.parksphere.model.Employee;

@WebServlet("/edit-employee")
public class EditEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int employeeId = Integer.parseInt(request.getParameter("id"));

		EmployeeDAO dao = new EmployeeDAOImpl();

		Employee employee = dao.getEmployeeById(employeeId);

		request.setAttribute("employee", employee);

		request.getRequestDispatcher("edit-employee.jsp").forward(request, response);
	}
}