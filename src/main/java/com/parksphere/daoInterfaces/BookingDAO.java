package com.parksphere.daoInterfaces;

import java.util.List;

import com.parksphere.model.Booking;

public interface BookingDAO {

	boolean createBooking(Booking booking);

	Booking getBookingById(int bookingId);

	Booking getBookingByEntryOtp(String otp);

	Booking getBookingByExitOtp(String otp);

	List<Booking> getBookingsByUserId(int userId);

	boolean updateBookingStatus(int bookingId, String status);
	
	boolean updateEntryTime(int bookingId);

	boolean updateExitOtp(int bookingId, String exitOtp);

	boolean completeBooking(int bookingId, double amount);

	List<Booking> getAllBookings();
	
	Booking getActiveBookingByUserId(int userId);

	boolean updateExitTime(int bookingId);

	boolean updateTotalAmount(int bookingId, double amount);
}
