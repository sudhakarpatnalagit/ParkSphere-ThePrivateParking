package com.parksphere.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.parksphere.daoInterfaces.AdminDAO;
import com.parksphere.model.Admin;
import com.parksphere.util.DBConnection;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin login(String username, String password) {

		Admin admin = null;

		try (Connection con = DBConnection.getConnection()) {

			System.out.println("Username = " + username);

			System.out.println("Password = " + password);

			String sql = "SELECT * FROM admins " + "WHERE username=? " + "AND password=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				System.out.println("ADMIN FOUND");

				admin = new Admin();

				admin.setAdminId(rs.getInt("admin_id"));

				admin.setUsername(rs.getString("username"));
			} else {

				System.out.println("ADMIN NOT FOUND");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return admin;
	}

	@Override
	public Admin getAdminById(int adminId) {

	    Admin admin = null;

	    try(Connection con =
	            DBConnection.getConnection()) {

	        String sql =
	            "SELECT * FROM admins " +
	            "WHERE admin_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setInt(1, adminId);

	        ResultSet rs =
	                ps.executeQuery();

	        if(rs.next()) {

	            admin = new Admin();

	            admin.setAdminId(
	                    rs.getInt("admin_id"));

	            admin.setUsername(
	                    rs.getString("username"));
	        }

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return admin;
	}

	@Override
	public boolean updateAdmin(Admin admin) {

	    try(Connection con =
	            DBConnection.getConnection()) {

	        String sql =
	            "UPDATE admins " +
	            "SET username=? " +
	            "WHERE admin_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setString(
	                1,
	                admin.getUsername());

	        ps.setInt(
	                2,
	                admin.getAdminId());

	        return ps.executeUpdate() > 0;

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return false;
	}

	@Override
	public boolean changePassword(
	        int adminId,
	        String password) {

	    try(Connection con =
	            DBConnection.getConnection()) {

	        String sql =
	            "UPDATE admins " +
	            "SET password=? " +
	            "WHERE admin_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(sql);

	        ps.setString(1, password);

	        ps.setInt(2, adminId);

	        return ps.executeUpdate() > 0;

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return false;
	}
}