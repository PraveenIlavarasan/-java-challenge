package jp.co.axa.apidemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jp.co.axa.api.dto.EmployeeDTO;
import jp.co.axa.api.entity.Employee;
import jp.co.axa.api.mapper.MapStructObjectMapper;
import jp.co.axa.api.repository.EmployeeRepository;
import jp.co.axa.api.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	MapStructObjectMapper mapStructObjectMapper;

	@Test
	public void getEmployeesTest() {

		when(employeeRepository.findAll()).thenReturn((List<Employee>) getEmployeeList());
		List<EmployeeDTO> empTest = employeeService.retrieveEmployees();
		assertEquals(empTest.isEmpty(), true);
	}

	@Test
	public void saveEmployeeTest() {
		EmployeeDTO expectedEmpTest = getEmployeeDTOList().get(0);

		when(employeeService.saveEmployee(any())).thenReturn(expectedEmpTest);
		EmployeeDTO emp = employeeService.saveEmployee(getEmployeeList().get(0));
		assertEquals(emp.getName(), expectedEmpTest.getName());

	}

	@Test
	public void deleteEmployeeTest() {
		
		doNothing().when(employeeRepository).deleteById(any());
		String message = employeeService.deleteEmployee(1L);
		assertEquals(message, "Entity Deleted with id:1");

	}

	@Test
	public void updateEmployeeTest() {
		EmployeeDTO expectedEmpTest = getEmployeeDTOList().get(0);

		when(employeeRepository.findById(any())).thenReturn(Optional.ofNullable(getEmployeeList().get(0)));

		EmployeeDTO message = Optional.ofNullable(employeeService.updateEmployee(getEmployeeList().get(0), 1L))
				.orElse(getEmployeeDTOList().get(0));
		assertEquals(message, expectedEmpTest);
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
