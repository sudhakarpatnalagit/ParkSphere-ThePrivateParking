package com.parksphere.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.parksphere.dao.TransactionDAOImpl;
import com.parksphere.model.Transaction;
import com.parksphere.model.User;

@WebServlet("/transaction-history")
public class TransactionHistoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		if (user == null) {

			response.sendRedirect("login.jsp");

			return;
		}

		TransactionDAOImpl dao = new TransactionDAOImpl();

		List<Transaction> transactions = dao.getTransactionsByUserId(user.getUserId());

		request.setAttribute("transactions", transactions);

		request.getRequestDispatcher("transaction-history.jsp").forward(request, response);
	}
}