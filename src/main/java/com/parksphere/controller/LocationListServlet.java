package com.parksphere.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.LocationDAOImpl;
import com.parksphere.daoInterfaces.LocationDAO;
import com.parksphere.model.Location;

@WebServlet("/locations-list")
public class LocationListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LocationDAO dao = new LocationDAOImpl();

		List<Location> locations = dao.getAllLocations();

		request.setAttribute("locations", locations);

		request.getRequestDispatcher("locations.jsp").forward(request, response);
	}
}