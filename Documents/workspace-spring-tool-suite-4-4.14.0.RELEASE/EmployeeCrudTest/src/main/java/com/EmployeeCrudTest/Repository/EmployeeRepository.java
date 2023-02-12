package com.EmployeeCrudTest.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeCrudTest.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	Optional<Employee> findByEmailId(Object object);

	Optional<Employee> findById(long id);

	void deleteById(long id);

	//Object findById();

}
