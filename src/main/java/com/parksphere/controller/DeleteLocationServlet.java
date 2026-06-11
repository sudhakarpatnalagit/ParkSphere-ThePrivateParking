package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.LocationDAOImpl;
import com.parksphere.daoInterfaces.LocationDAO;

@WebServlet("/delete-location")
public class DeleteLocationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int locationId = Integer.parseInt(request.getParameter("id"));

		LocationDAO dao = new LocationDAOImpl();

		dao.deleteLocation(locationId);

		response.sendRedirect("locations-list");
	}
}