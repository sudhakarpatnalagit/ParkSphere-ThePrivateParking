package com.parksphere.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parksphere.dao.BookingDAOImpl;
import com.parksphere.dao.TransactionDAOImpl;
import com.parksphere.daoInterfaces.BookingDAO;
import com.parksphere.daoInterfaces.TransactionDAO;
import com.parksphere.model.Booking;
import com.parksphere.model.Transaction;
import com.parksphere.service.PriceEngine;

@WebServlet("/validateExit")
public class ExitValidationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String otp = request.getParameter("otp");

		BookingDAO bookingDAO = new BookingDAOImpl();

		Booking booking = bookingDAO.getBookingByExitOtp(otp);

		if (booking == null) {

			response.sendRedirect("vehicle-exit.jsp?error=1");

			return;
		}

		PriceEngine engine = new PriceEngine();

		double amount = engine.calculateAmount(booking.getEntryTime().toLocalDateTime(), LocalDateTime.now());

		Transaction tx = new Transaction();

		tx.setBookingId(booking.getBookingId());

		tx.setAmount(amount);

		tx.setPaymentStatus("PENDING");

		TransactionDAO txDAO = new TransactionDAOImpl();

		txDAO.addTransaction(tx);

		bookingDAO.completeBooking(booking.getBookingId(), amount);

		request.setAttribute("amount", amount);

		request.getRequestDispatcher("bill.jsp").forward(request, response);
	}
}