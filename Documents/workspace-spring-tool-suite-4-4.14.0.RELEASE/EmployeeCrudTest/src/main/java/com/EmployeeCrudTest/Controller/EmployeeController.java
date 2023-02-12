package com.EmployeeCrudTest.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeCrudTest.Entity.Employee;
import com.EmployeeCrudTest.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	/*public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeService = employeeService;
	}*/
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee  employee) {
		return employeeService.saveEmployee(employee);	
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee() {
		//System.out.println("getting values from Db"+ employeeService);
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
        
       return employeeService.getEmployeeById(employeeId)
           .map(savedEmployee -> {
           savedEmployee.setFirstName(employee.getFirstName());
           savedEmployee.setLastName(employee.getLastName());
           savedEmployee.setEmailId(employee.getEmailId());

           Employee updatedEmployee = employeeService.updateEmployee(savedEmployee);
           return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
           })
           .orElseGet(() -> ResponseEntity.notFound().build());
	       }
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee deleted Successfully!.", HttpStatus.OK );
	}
	 
	
	
	
}
