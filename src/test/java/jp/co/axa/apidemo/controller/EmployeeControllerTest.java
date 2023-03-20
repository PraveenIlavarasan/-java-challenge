package jp.co.axa.apidemo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import jp.co.axa.api.controller.EmployeeController;
import jp.co.axa.api.dto.EmployeeDTO;
import jp.co.axa.api.entity.Employee;
import jp.co.axa.api.mapper.MapStructObjectMapper;
import jp.co.axa.api.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;
	
	@Mock
	MapStructObjectMapper mapStructObjectMapper; 

	@BeforeEach
	void setUp() {

	}


	@Test
	public void saveEmployeeTest() {
		EmployeeDTO expectedEmpTest = getEmployeeDTOList().get(0);

		when(employeeService.saveEmployee(any())).thenReturn(expectedEmpTest);
		ResponseEntity<EmployeeDTO> emp = employeeController.saveEmployee(getEmployeeList().get(0));
		assertEquals(emp.getBody().getName(), expectedEmpTest.getName());

	}

	@Test
	public void deleteEmployeeTest() {

		when(employeeService.deleteEmployee(any())).thenReturn("Entity Removed");
		ResponseEntity<String> message = employeeController.deleteEmployee(1L);
		assertEquals(message.getBody(), "Entity Removed");

	}

	@Test
	public void updateEmployeeTest() {
		EmployeeDTO expectedEmpTest = getEmployeeDTOList().get(0);

		when(employeeService.updateEmployee(any(), any())).thenReturn(expectedEmpTest);

		ResponseEntity<EmployeeDTO> message = employeeController.updateEmployee(getEmployeeList().get(0), 1L);
		assertEquals(message.getBody().getName(), expectedEmpTest.getName());
	}

	public List<Employee> getEmployeeList() {
		Employee empObjl = new Employee();
		empObjl.setName("Chandru");
		Employee empObj2 = new Employee();
		empObj2.setName("Praveen");
		List<Employee> empTest = new ArrayList<Employee>();
		empTest.add(empObjl);
		empTest.add(empObj2);
		return empTest;
	}
	
	public List<EmployeeDTO> getEmployeeDTOList() {
		EmployeeDTO empObjl = new EmployeeDTO();
		empObjl.setName("Chandru");
		EmployeeDTO empObj2 = new EmployeeDTO();
		empObj2.setName("Praveen");
		List<EmployeeDTO> empTest = new ArrayList<EmployeeDTO>();
		empTest.add(empObjl);
		empTest.add(empObj2);
		return empTest;
	}
}
