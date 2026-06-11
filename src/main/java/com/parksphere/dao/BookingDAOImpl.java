package com.parksphere.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.parksphere.daoInterfaces.BookingDAO;
import com.parksphere.model.Booking;
import com.parksphere.util.DBConnection;

public class BookingDAOImpl implements BookingDAO {

	@Override
	public boolean createBooking(Booking booking) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "INSERT INTO bookings(" + "user_id,slot_id,vehicle_number," + "vehicle_type,entry_otp,"
					+ "booking_status) " + "VALUES(?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, booking.getUserId());
			ps.setInt(2, booking.getSlotId());
			ps.setString(3, booking.getVehicleNumber());
			ps.setString(4, booking.getVehicleType());
			ps.setString(5, booking.getEntryOtp());
			ps.setString(6, booking.getBookingStatus());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Booking getBookingById(int bookingId) {

		Booking booking = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM bookings " + "WHERE booking_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, bookingId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));

				booking.setUserId(rs.getInt("user_id"));

				booking.setSlotId(rs.getInt("slot_id"));

				booking.setVehicleNumber(rs.getString("vehicle_number"));

				booking.setVehicleType(rs.getString("vehicle_type"));

				booking.setEntryOtp(rs.getString("entry_otp"));

				booking.setExitOtp(rs.getString("exit_otp"));

				booking.setBookingStatus(rs.getString("booking_status"));

				booking.setTotalAmount(rs.getDouble("total_amount"));

				booking.setEntryTime(rs.getTimestamp("entry_time"));

				booking.setExitTime(rs.getTimestamp("exit_time"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return booking;
	}

	@Override
	public Booking getBookingByEntryOtp(String otp) {

		Booking booking = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM bookings " + "WHERE entry_otp=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, otp);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));

				booking.setUserId(rs.getInt("user_id"));

				booking.setSlotId(rs.getInt("slot_id"));

				booking.setVehicleNumber(rs.getString("vehicle_number"));

				booking.setVehicleType(rs.getString("vehicle_type"));

				booking.setEntryOtp(rs.getString("entry_otp"));

				booking.setBookingStatus(rs.getString("booking_status"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return booking;
	}

	@Override
	public Booking getBookingByExitOtp(String otp) {

		Booking booking = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM bookings " + "WHERE exit_otp=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, otp);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));

				booking.setSlotId(rs.getInt("slot_id"));

				booking.setUserId(rs.getInt("user_id"));

				booking.setVehicleNumber(rs.getString("vehicle_number"));

				booking.setBookingStatus(rs.getString("booking_status"));

				booking.setEntryTime(rs.getTimestamp("entry_time"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return booking;
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {

		List<Booking> bookings = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM bookings " + "WHERE user_id=? " + "ORDER BY booking_id DESC";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Booking booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));

				booking.setVehicleNumber(rs.getString("vehicle_number"));

				booking.setBookingStatus(rs.getString("booking_status"));

				booking.setTotalAmount(rs.getDouble("total_amount"));

				bookings.add(booking);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return bookings;
	}

	@Override
	public boolean updateEntryTime(int bookingId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE bookings " + "SET entry_time=NOW() " + "WHERE booking_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, bookingId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateBookingStatus(int bookingId, String status) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE bookings " + "SET booking_status=? " + "WHERE booking_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, status);
			ps.setInt(2, bookingId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateExitTime(int bookingId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE bookings " + "SET exit_time=NOW() " + "WHERE booking_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, bookingId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateExitOtp(int bookingId, String otp) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE bookings " + "SET exit_otp=? " + "WHERE booking_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, otp);

			ps.setInt(2, bookingId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean completeBooking(int bookingId, double amount) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE bookings " + "SET total_amount=?," + "booking_status='COMPLETED' "
					+ "WHERE booking_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, amount);
			ps.setInt(2, bookingId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Booking> getAllBookings() {

		List<Booking> bookings = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM bookings";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Booking booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));

				booking.setUserId(rs.getInt("user_id"));

				booking.setBookingStatus(rs.getString("booking_status"));

				bookings.add(booking);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return bookings;
	}

	@Override
	public boolean updateTotalAmount(int bookingId, double amount) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE bookings " + "SET total_amount=? " + "WHERE booking_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, amount);

			ps.setInt(2, bookingId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Booking getActiveBookingByUserId(int userId) {

		Booking booking = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM bookings " + "WHERE user_id=? " + "AND booking_status IN "
					+ "('BOOKED','PARKED','CHECKOUT_REQUESTED') " + "ORDER BY booking_id DESC LIMIT 1";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));

				booking.setUserId(rs.getInt("user_id"));

				booking.setSlotId(rs.getInt("slot_id"));

				booking.setVehicleNumber(rs.getString("vehicle_number"));

				booking.setVehicleType(rs.getString("vehicle_type"));

				booking.setEntryOtp(rs.getString("entry_otp"));

				booking.setExitOtp(rs.getString("exit_otp"));

				booking.setBookingStatus(rs.getString("booking_status"));

				booking.setTotalAmount(rs.getDouble("total_amount"));

				booking.setEntryTime(rs.getTimestamp("entry_time"));

				booking.setExitTime(rs.getTimestamp("exit_time"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return booking;
	}
}