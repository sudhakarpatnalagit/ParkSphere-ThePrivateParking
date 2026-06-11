package com.parksphere.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.BookingDAOImpl;
import com.parksphere.model.Booking;
import com.parksphere.service.OTPGenerator;
import com.parksphere.service.PriceEngine;

@WebServlet("/checkout-request")
public class CheckoutRequestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookingId = Integer.parseInt(request.getParameter("bookingId"));

		BookingDAOImpl dao = new BookingDAOImpl();

		Booking booking = dao.getBookingById(bookingId);

		if (booking == null) {

			response.sendRedirect("user-dashboard.jsp");

			return;
		}

		PriceEngine engine = new PriceEngine();

		double amount = engine.calculateAmount(booking.getEntryTime(), LocalDateTime.now(), 30);

		dao.updateTotalAmount(bookingId, amount);

		String exitOtp = OTPGenerator.generateOTP();

		dao.updateExitOtp(bookingId, exitOtp);

		dao.updateBookingStatus(bookingId, "CHECKOUT_REQUESTED");

		response.sendRedirect("user-dashboard.jsp");
	}
}