package com.EmployeeCrudTest;



import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.EmployeeCrudTest.Entity.Employee;
import com.EmployeeCrudTest.Repository.EmployeeRepository;
import com.EmployeeCrudTest.Service.EmployeeService;


@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest
class EmployeeCrudTestApplicationTests {

	
	@Autowired
    private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	public void getAllEmployeeTest() {
		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(411412110,"Raj","Kumar","test@gmail.com"),new Employee(411412111,"Rajesh","Laxman","rajeshlax@gmail.com")).collect(Collectors.toList()));
		assertEquals(2, employeeService.getAllEmployee().size());
		//verify(employeeRepository,times(1)).findAll();
	}
	
	@Test
	public void getEmployeeByIdTest() {
		Employee employee=new Employee(411412111,"Rajesh","Laxman","rajeshlax@gmail.com");
		when(employeeRepository.findById(411412111)).thenReturn(Optional.of(employee));
		assertEquals(Optional.of(employee), employeeService.getEmployeeById(411412111));
	}
	
	
	@Test
	public void saveEmployeeTest() {
		Employee employee =new Employee(411412112,"Ramesh","Ranganathan","rameshranga@gmail.com");
		when(employeeRepository.save(employee)).thenReturn(employee);
		//verify(employeeRepository,times(1)).save(employee);
		//assertEquals(employee, employeeService.saveEmployee(employee));
	}
	

	@Test
	public void deleteEmployeeTest() {
		Employee employee =new Employee(411412111,"Rajesh","Laxman","rajeshlax@gmail.com");
		employeeService.deleteEmployee(411412111);
		verify(employeeRepository,times(1)).deleteById(411412111);
	}
	
	
	@Test
	public void  updateEmployeeTest() {
		employeeRepository.findById(411412111);
		Employee updatedEmployee=new Employee(411412111,"Rajesh","Laxman","rajeshlaxman1234@gmail.com");
		employeeService.updateEmployee(updatedEmployee);
		//verify(employeeRepository,times(1)).save(updatedEmployee);
		when(employeeRepository.save(updatedEmployee)).thenReturn(updatedEmployee);
	}
	
	
	
	
	
	
	/*@Test
	public void saveEmployeeTest() {
		Employee employee=new Employee(411412112,"Ramesh","Ranganathan","rameshranga@gmail.com");
		when(employeeRepository.save(employee)).thenReturn(employee) ;
		assertEquals(employee, employeeService.saveEmployee(employee));
	}*/
	
/*//*@Test
	void contextLoads() {
		//mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}*/

}
