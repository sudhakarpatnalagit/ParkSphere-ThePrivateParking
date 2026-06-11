package com.parksphere.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.parksphere.daoInterfaces.LocationDAO;
import com.parksphere.model.Location;
import com.parksphere.util.DBConnection;

public class LocationDAOImpl implements LocationDAO {

	@Override
	public boolean addLocation(Location location) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "INSERT INTO parking_locations(" + "location_name,address,total_slots) " + "VALUES(?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, location.getLocationName());

			ps.setString(2, location.getAddress());

			ps.setInt(3, location.getTotalSlots());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateLocation(Location location) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE parking_locations SET " + "location_name=?," + "address=?," + "total_slots=? "
					+ "WHERE location_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, location.getLocationName());

			ps.setString(2, location.getAddress());

			ps.setInt(3, location.getTotalSlots());

			ps.setInt(4, location.getLocationId());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteLocation(int locationId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "DELETE FROM parking_locations " + "WHERE location_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, locationId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Location getLocationById(int locationId) {

		Location location = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM parking_locations " + "WHERE location_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, locationId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				location = new Location();

				location.setLocationId(rs.getInt("location_id"));

				location.setLocationName(rs.getString("location_name"));

				location.setAddress(rs.getString("address"));

				location.setTotalSlots(rs.getInt("total_slots"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return location;
	}

	@Override
	public List<Location> getAllLocations() {

		List<Location> locations = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM parking_locations";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Location location = new Location();

				location.setLocationId(rs.getInt("location_id"));

				location.setLocationName(rs.getString("location_name"));

				location.setAddress(rs.getString("address"));

				location.setTotalSlots(rs.getInt("total_slots"));

				locations.add(location);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return locations;
	}
}