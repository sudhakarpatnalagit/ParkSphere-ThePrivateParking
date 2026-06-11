package com.parksphere.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parksphere.dao.BookingDAOImpl;
import com.parksphere.dao.ParkingSlotDAOImpl;
import com.parksphere.daoInterfaces.BookingDAO;
import com.parksphere.daoInterfaces.ParkingSlotDAO;
import com.parksphere.model.Booking;
import com.parksphere.model.ParkingSlot;
import com.parksphere.model.User;
import com.parksphere.service.OTPGenerator;

@WebServlet("/bookSlot")
public class BookSlotServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		if (user == null) {

			response.sendRedirect("login.jsp");

			return;
		}

		int locationId = Integer.parseInt(request.getParameter("locationId"));

		String vehicleNumber = request.getParameter("vehicleNumber");

		String vehicleType = "CAR";

		ParkingSlotDAO slotDAO = new ParkingSlotDAOImpl();

		List<ParkingSlot> slots = slotDAO.getAvailableSlots(locationId, vehicleType);

		if (slots == null || slots.isEmpty()) {

			response.getWriter().println("No Slots Available");

			return;
		}

		ParkingSlot slot = slots.get(0);

		String otp = OTPGenerator.generateOTP();

		Booking booking = new Booking();

		booking.setUserId(user.getUserId());

		booking.setSlotId(slot.getSlotId());

		booking.setVehicleNumber(vehicleNumber);

		booking.setVehicleType(vehicleType);

		booking.setEntryOtp(otp);

		booking.setBookingStatus("BOOKED");

		BookingDAO bookingDAO = new BookingDAOImpl();

		boolean success = bookingDAO.createBooking(booking);

		if (success) {

			slotDAO.reserveSlot(slot.getSlotId());

			request.setAttribute("otp", otp);

			request.setAttribute("slotNumber", slot.getSlotNumber());

			request.getRequestDispatcher("booking-success.jsp").forward(request, response);
		} else {

			response.getWriter().println("Booking Failed");
		}
	}

}
