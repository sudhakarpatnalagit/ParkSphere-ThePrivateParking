package com.parksphere.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.EmployeeDAOImpl;
import com.parksphere.daoInterfaces.EmployeeDAO;
import com.parksphere.model.Employee;

@WebServlet("/employees-list")
public class EmployeesListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDAO dao = new EmployeeDAOImpl();

		List<Employee> employees = dao.getAllEmployees();

		request.setAttribute("employees", employees);

		request.getRequestDispatcher("employees.jsp").forward(request, response);
	}
}