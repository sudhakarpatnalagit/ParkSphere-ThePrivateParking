package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.LocationDAOImpl;
import com.parksphere.daoInterfaces.LocationDAO;
import com.parksphere.model.Location;

@WebServlet("/add-location")
public class AddLocationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Location location = new Location();

		location.setLocationName(request.getParameter("locationName"));

		location.setAddress(request.getParameter("address"));

		location.setTotalSlots(Integer.parseInt(request.getParameter("totalSlots")));

		LocationDAO dao = new LocationDAOImpl();

		dao.addLocation(location);

		response.sendRedirect("locations-list");
	}
}