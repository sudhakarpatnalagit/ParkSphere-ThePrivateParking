package com.parksphere.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.parksphere.dao.BookingDAOImpl;
import com.parksphere.dao.ParkingSlotDAOImpl;
import com.parksphere.dao.TransactionDAOImpl;
import com.parksphere.model.Booking;
import com.parksphere.model.Transaction;
import com.parksphere.service.PriceEngine;

@WebServlet("/exit-check")
public class ExitCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String otp = request.getParameter("otp").trim();

		BookingDAOImpl bookingDAO = new BookingDAOImpl();

		Booking booking = bookingDAO.getBookingByExitOtp(otp);

		if (booking == null) {

			response.sendRedirect("exit-check.jsp?error=1");

			return;
		}

		PriceEngine engine = new PriceEngine();

		double amount = engine.calculateAmount(booking.getEntryTime(), LocalDateTime.now(), 30);

		bookingDAO.updateTotalAmount(booking.getBookingId(), amount);

		bookingDAO.updateExitTime(booking.getBookingId());

		bookingDAO.updateBookingStatus(booking.getBookingId(), "COMPLETED");

		ParkingSlotDAOImpl slotDAO = new ParkingSlotDAOImpl();

		slotDAO.releaseSlot(booking.getSlotId());

		Transaction tx = new Transaction();

		tx.setBookingId(booking.getBookingId());

		tx.setAmount(amount);

		tx.setPaymentMethod("CASH");

		tx.setPaymentStatus("SUCCESS");

		new TransactionDAOImpl().addTransaction(tx);

		response.sendRedirect("exit-check.jsp?success=1");
	}
}