package com.parksphere.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.parksphere.daoInterfaces.ParkingSlotDAO;
import com.parksphere.model.ParkingSlot;
import com.parksphere.util.DBConnection;

public class ParkingSlotDAOImpl implements ParkingSlotDAO {

	@Override
	public List<ParkingSlot> getAvailableSlots(int locationId, String vehicleType) {

		List<ParkingSlot> slots = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM parking_slots " + "WHERE location_id=? " + "AND vehicle_type=? "
					+ "AND is_available=TRUE";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, locationId);
			ps.setString(2, vehicleType);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ParkingSlot slot = new ParkingSlot();

				slot.setSlotId(rs.getInt("slot_id"));

				slot.setLocationId(rs.getInt("location_id"));

				slot.setSlotNumber(rs.getString("slot_number"));

				slot.setVehicleType(rs.getString("vehicle_type"));

				slot.setAvailable(rs.getBoolean("is_available"));

				slots.add(slot);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return slots;
	}

	@Override
	public ParkingSlot getSlotById(int slotId) {

		ParkingSlot slot = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM parking_slots " + "WHERE slot_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, slotId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				slot = new ParkingSlot();

				slot.setSlotId(rs.getInt("slot_id"));

				slot.setLocationId(rs.getInt("location_id"));

				slot.setSlotNumber(rs.getString("slot_number"));

				slot.setVehicleType(rs.getString("vehicle_type"));

				slot.setAvailable(rs.getBoolean("is_available"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return slot;
	}

	@Override
	public boolean reserveSlot(int slotId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE parking_slots " + "SET is_available=FALSE " + "WHERE slot_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, slotId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean releaseSlot(int slotId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE parking_slots " + "SET is_available=TRUE " + "WHERE slot_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, slotId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addSlot(ParkingSlot slot) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "INSERT INTO parking_slots(" + "location_id," + "slot_number," + "vehicle_type,"
					+ "is_available) " + "VALUES(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, slot.getLocationId());

			ps.setString(2, slot.getSlotNumber());

			ps.setString(3, slot.getVehicleType());

			ps.setBoolean(4, slot.isAvailable());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteSlot(int slotId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "DELETE FROM parking_slots " + "WHERE slot_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, slotId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}