package com.EmployeeCrudTest.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeCrudTest.Entity.Employee;
import com.EmployeeCrudTest.Exception.ResourceNotFoundException;
import com.EmployeeCrudTest.Repository.EmployeeRepository;
import com.EmployeeCrudTest.Service.EmployeeService;


	@Service
	public class EmployeeServiceImpl implements EmployeeService {

		@Autowired
		EmployeeRepository employeeRepository;
		
		
		
		
		public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
			super();
			this.employeeRepository = employeeRepository;
		}

		@Override
		public Employee saveEmployee(Employee employee) {
			Optional<Employee> savedEmployee = employeeRepository.findByEmailId(employee.getEmailId());
			if(savedEmployee.isEmpty()) {
				throw new ResourceNotFoundException("Employee Id already Exist "+employee.getEmailId());
			}
				else {
					return employeeRepository.save(employee);
				}
		}

		@Override
		public List<Employee> getAllEmployee() {
			// TODO Auto-generated method stub
			List <Employee> employee=employeeRepository.findAll();
			System.out.println("getting data from db" + employee);
			return employee;
		}

		@Override
		public Optional<Employee> getEmployeeById(long id) {
			// TODO Auto-generated method stub
			return employeeRepository.findById(id);
		}

		@Override
		public Employee updateEmployee(Employee updatedEmployee) {
			// TODO Auto-generated method stub
			System.out.println("get values: "+updatedEmployee);
			return employeeRepository.save(updatedEmployee);
		}

		@Override
		public void deleteEmployee(long id) {
			// TODO Auto-generated method stub
			employeeRepository.deleteById(id);
		}	
	}



