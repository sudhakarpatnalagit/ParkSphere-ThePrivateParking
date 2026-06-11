package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parksphere.dao.EmployeeDAOImpl;
import com.parksphere.daoInterfaces.EmployeeDAO;
import com.parksphere.model.Employee;

@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		Employee emp = new Employee();
		
		emp.setLocationId(Integer.parseInt(request.getParameter("locationId")));

		emp.setFullName(request.getParameter("fullName"));

		emp.setEmail(request.getParameter("email"));

		emp.setPhone(request.getParameter("phone"));

		emp.setPassword(request.getParameter("password"));

		emp.setStatus(request.getParameter("status"));

		EmployeeDAO dao = new EmployeeDAOImpl();

		dao.addEmployee(emp);

		response.sendRedirect("employees-list");
	}
}