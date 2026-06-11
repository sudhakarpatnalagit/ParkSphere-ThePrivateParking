package com.parksphere.daoInterfaces;



import java.util.List;

import com.parksphere.model.Employee;


public interface EmployeeDAO {

    boolean addEmployee(Employee employee);

    Employee login(String email, String password);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployees();

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int employeeId);
}
