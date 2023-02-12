/*package com.EmployeeCrudTest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import com.EmployeeCrudTest.Controller.EmployeeController;
import com.EmployeeCrudTest.Entity.Employee;
import com.EmployeeCrudTest.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	
	@MockBean
	private EmployeeService employeeService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void givenEmployeeObject_whenCreatedEmployee_thenReturnSavedEmployee() throws Exception {
		  Employee employee = Employee.builder()
	                .setFirstName("Raj")
	                .setLastName("Kumar")
	                .setEmailId("Test@gmail.com");
		  	       
			Mockito.when(employeeService.saveEmployee(any(Employee.class))).thenReturn(employee);
		

	        // when - action or behaviour that we are going test
	        ResultActions response = mockmvc.perform(post("/api/employees")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(employee)));

	        // then - verify the result or output using assert statements
	        response.andDo(print()).
	                andExpect(status().isCreated())
	                .andExpect(jsonPath("$.firstName",
	                        is(employee.getFirstName())))
	                .andExpect(jsonPath("$.lastName",
	                        is(employee.getLastName())))
	                .andExpect(jsonPath("$.emailId",
	                        is(employee.getEmailId())));

	    }
	
	  @Test
	    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception{
	        // given - precondition or setup
	        List<Employee> listOfEmployees = new ArrayList<>();
	        listOfEmployees.add(Employee.builder().setFirstName("Ramesh").setLastName("Fadatare").setEmailId("ramesh@gmail.com"));
	        listOfEmployees.add(Employee.builder().setFirstName("Tony").setLastName("Stark").setEmailId("tony@gmail.com"));
	        Mockito.when(employeeService.getAllEmployee()).thenReturn(listOfEmployees);

	        // when -  action or the behaviour that we are going test
	        ResultActions response = mockmvc.perform(get("/api/employees"));

	        // then - verify the output
	        response.andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(jsonPath("$.size()",
	                        is(listOfEmployees.size())));

	    }
	
	
	
	
	
}*/



