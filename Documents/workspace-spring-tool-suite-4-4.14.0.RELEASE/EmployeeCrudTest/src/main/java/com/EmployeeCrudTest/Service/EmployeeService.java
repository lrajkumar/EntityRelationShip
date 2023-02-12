package com.EmployeeCrudTest.Service;

import java.util.List;
import java.util.Optional;

import com.EmployeeCrudTest.Entity.Employee;

public interface EmployeeService {
 
	   Employee saveEmployee(Employee employee);
	   List<Employee> getAllEmployee();
	   Optional<Employee> getEmployeeById(long id);
	   Employee updateEmployee(Employee updatedEmployee);
	   void deleteEmployee(long employeeId);
	   
	
}
