package com.parksphere.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.parksphere.daoInterfaces.TransactionDAO;
import com.parksphere.model.Transaction;
import com.parksphere.util.DBConnection;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public boolean addTransaction(Transaction transaction) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "INSERT INTO transactions(" + "booking_id,amount," + "payment_method," + "payment_status) "
					+ "VALUES(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, transaction.getBookingId());

			ps.setDouble(2, transaction.getAmount());

			ps.setString(3, transaction.getPaymentMethod());

			ps.setString(4, transaction.getPaymentStatus());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Transaction getTransactionById(int transactionId) {

		Transaction transaction = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM transactions " + "WHERE transaction_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, transactionId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				transaction = new Transaction();

				transaction.setTransactionId(rs.getInt("transaction_id"));

				transaction.setBookingId(rs.getInt("booking_id"));

				transaction.setAmount(rs.getDouble("amount"));

				transaction.setPaymentMethod(rs.getString("payment_method"));

				transaction.setPaymentStatus(rs.getString("payment_status"));

				transaction.setTransactionTime(rs.getTimestamp("transaction_time"));

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return transaction;
	}

	@Override
	public Transaction getTransactionByBookingId(int bookingId) {

		Transaction transaction = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM transactions " + "WHERE booking_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, bookingId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				transaction = new Transaction();

				transaction.setTransactionId(rs.getInt("transaction_id"));

				transaction.setBookingId(rs.getInt("booking_id"));

				transaction.setAmount(rs.getDouble("amount"));

				transaction.setPaymentMethod(rs.getString("payment_method"));

				transaction.setPaymentStatus(rs.getString("payment_status"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return transaction;
	}

	@Override
	public List<Transaction> getAllTransactions() {

		List<Transaction> transactions = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM transactions";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Transaction transaction = new Transaction();

				transaction.setTransactionId(rs.getInt("transaction_id"));

				transaction.setBookingId(rs.getInt("booking_id"));

				transaction.setAmount(rs.getDouble("amount"));

				transaction.setPaymentMethod(rs.getString("payment_method"));

				transaction.setPaymentStatus(rs.getString("payment_status"));

				transactions.add(transaction);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return transactions;
	}

	@Override
	public List<Transaction> getTransactionsByStatus(String status) {

		List<Transaction> transactions = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM transactions " + "WHERE payment_status=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, status);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Transaction transaction = new Transaction();

				transaction.setTransactionId(rs.getInt("transaction_id"));

				transaction.setBookingId(rs.getInt("booking_id"));

				transaction.setAmount(rs.getDouble("amount"));

				transaction.setPaymentMethod(rs.getString("payment_method"));

				transaction.setPaymentStatus(rs.getString("payment_status"));

				transactions.add(transaction);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return transactions;
	}

	@Override
	public boolean updatePaymentStatus(int transactionId, String paymentStatus) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE transactions " + "SET payment_status=? " + "WHERE transaction_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, paymentStatus);

			ps.setInt(2, transactionId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteTransaction(int transactionId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "DELETE FROM transactions " + "WHERE transaction_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, transactionId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Transaction> getTransactionsByUserId(int userId) {

		List<Transaction> list = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT t.* " + "FROM transactions t " + "JOIN bookings b " + "ON t.booking_id=b.booking_id "
					+ "WHERE b.user_id=? " + "ORDER BY t.transaction_id DESC";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Transaction tx = new Transaction();

				tx.setTransactionId(rs.getInt("transaction_id"));

				tx.setBookingId(rs.getInt("booking_id"));

				tx.setAmount(rs.getDouble("amount"));

				tx.setPaymentMethod(rs.getString("payment_method"));

				tx.setPaymentStatus(rs.getString("payment_status"));

				list.add(tx);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

}