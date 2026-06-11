package com.parksphere.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.parksphere.daoInterfaces.UserDAO;
import com.parksphere.model.User;
import com.parksphere.util.DBConnection;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean registerUser(User user) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "INSERT INTO users(full_name,email,phone,password) " + "VALUES(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getPassword());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User login(String email, String password) {

		User user = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM users " + "WHERE email=? AND password=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new User();

				user.setUserId(rs.getInt("user_id"));

				user.setFullName(rs.getString("full_name"));

				user.setEmail(rs.getString("email"));

				user.setPhone(rs.getString("phone"));

				user.setPassword(rs.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserById(int userId) {

		User user = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM users " + "WHERE user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new User();

				user.setUserId(rs.getInt("user_id"));

				user.setFullName(rs.getString("full_name"));

				user.setEmail(rs.getString("email"));

				user.setPhone(rs.getString("phone"));

				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM users";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				User user = new User();

				user.setUserId(rs.getInt("user_id"));

				user.setFullName(rs.getString("full_name"));

				user.setEmail(rs.getString("email"));

				user.setPhone(rs.getString("phone"));

				user.setPassword(rs.getString("password"));

				user.setWalletBalance(rs.getDouble("wallet_balance"));

				user.setStatus(rs.getString("status"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public boolean updateUser(User user) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE users SET " + "full_name=?," + "email=?," + "phone=?," + "password=? "
					+ "WHERE user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getFullName());

			ps.setString(2, user.getEmail());

			ps.setString(3, user.getPhone());

			ps.setString(4, user.getPassword());

			ps.setInt(5, user.getUserId());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteUser(int userId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "DELETE FROM users " + "WHERE user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean blockUser(int userId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE users SET " + "status='BLOCKED' " + "WHERE user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean activateUser(int userId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE users SET " + "status='ACTIVE' " + "WHERE user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}