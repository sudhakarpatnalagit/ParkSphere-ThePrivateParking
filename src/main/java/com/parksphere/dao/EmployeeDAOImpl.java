package com.parksphere.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.parksphere.daoInterfaces.EmployeeDAO;
import com.parksphere.model.Employee;
import com.parksphere.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean addEmployee(Employee emp) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "INSERT INTO employees(" + "location_id,full_name,email," + "phone,password,status) "
					+ "VALUES(?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, emp.getLocationId());
			ps.setString(2, emp.getFullName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getPassword());
			ps.setString(6, emp.getStatus());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Employee login(String email, String password) {

		Employee employee = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM employees " + "WHERE email=? " + "AND password=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				employee = new Employee();

				employee.setEmployeeId(rs.getInt("employee_id"));

				employee.setLocationId(rs.getInt("location_id"));

				employee.setFullName(rs.getString("full_name"));

				employee.setEmail(rs.getString("email"));

				employee.setPhone(rs.getString("phone"));

				employee.setPassword(rs.getString("password"));

				employee.setStatus(rs.getString("status"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		Employee employee = null;

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM employees " + "WHERE employee_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, employeeId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				employee = new Employee();

				employee.setEmployeeId(rs.getInt("employee_id"));

				employee.setLocationId(rs.getInt("location_id"));

				employee.setFullName(rs.getString("full_name"));

				employee.setEmail(rs.getString("email"));

				employee.setPhone(rs.getString("phone"));

				employee.setPassword(rs.getString("password"));

				employee.setStatus(rs.getString("status"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<>();

		try (Connection con = DBConnection.getConnection()) {

			String sql = "SELECT * FROM employees";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Employee employee = new Employee();

				employee.setEmployeeId(rs.getInt("employee_id"));

				employee.setLocationId(rs.getInt("location_id"));

				employee.setFullName(rs.getString("full_name"));

				employee.setEmail(rs.getString("email"));

				employee.setPhone(rs.getString("phone"));

				employee.setPassword(rs.getString("password"));

				employee.setStatus(rs.getString("status"));

				employees.add(employee);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "UPDATE employees SET " + "location_id=?," + "full_name=?," + "email=?," + "phone=?,"
					+ "password=?," + "status=? " + "WHERE employee_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, employee.getLocationId());

			ps.setString(2, employee.getFullName());

			ps.setString(3, employee.getEmail());

			ps.setString(4, employee.getPhone());

			ps.setString(5, employee.getPassword());

			ps.setString(6, employee.getStatus());

			ps.setInt(7, employee.getEmployeeId());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {

		try (Connection con = DBConnection.getConnection()) {

			String sql = "DELETE FROM employees " + "WHERE employee_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, employeeId);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}