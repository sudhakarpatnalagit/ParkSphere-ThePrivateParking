package com.parksphere.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.BookingDAOImpl;
import com.parksphere.daoInterfaces.BookingDAO;
import com.parksphere.model.Booking;

@WebServlet("/entry-check")
public class EntryCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String otp = request.getParameter("otp").trim();

		BookingDAO bookingDAO = new BookingDAOImpl();

		Booking booking = bookingDAO.getBookingByEntryOtp(otp);

		if (booking != null && "BOOKED".equals(booking.getBookingStatus())) {

			bookingDAO.updateBookingStatus(booking.getBookingId(), "PARKED");

			bookingDAO.updateEntryTime(booking.getBookingId());

			response.sendRedirect("entry-check.jsp?success=1");
		} else {

			response.sendRedirect("entry-check.jsp?error=1");
		}
	}
}