package com.parksphere.daoInterfaces;

import java.util.List;

import com.parksphere.model.Transaction;

public interface TransactionDAO {

	boolean addTransaction(Transaction transaction);

	Transaction getTransactionById(int transactionId);

	Transaction getTransactionByBookingId(int bookingId);

	List<Transaction> getAllTransactions();

	List<Transaction> getTransactionsByStatus(String status);

	boolean updatePaymentStatus(int transactionId, String paymentStatus);

	boolean deleteTransaction(int transactionId);

	List<Transaction> getTransactionsByUserId(int userId);
}