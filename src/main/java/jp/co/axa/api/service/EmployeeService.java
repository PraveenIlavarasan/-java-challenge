package jp.co.axa.api.service;

import java.util.List;

import jp.co.axa.api.dto.EmployeeDTO;
import jp.co.axa.api.entity.Employee;

public interface EmployeeService {
	
	
	/**
	 * @param pageNo The page number to retrieve (starting from 0)
	 * @param pageSize The number of employees to include per page
	 * @param sortBy The field to sort the employees by (default is "id")
	 * @return A paginated list of employees
	 */
	public List<EmployeeDTO> getAllEmployeesPageable(Integer pageNo, Integer pageSize, String sortBy);

	/**
	 * @param employeeId ID of the employee to retrieve
	 * @return The employee with the specified ID
	 */
	public EmployeeDTO getEmployee(Long employeeId);

	/**
	 * @param employee
	 * @return The created employee DTO
	 */
	public EmployeeDTO saveEmployee(Employee employee);

	/**
	 * @param employeeId ID of the employee to delete 
	 */
	public String deleteEmployee(Long employeeId);

	/**
	 * @param employeeId ID of the employee to update
	 * @param employee Details of the employee to update
	 * @return The updated employee
	 */
	public EmployeeDTO updateEmployee(Employee employee, Long employeeId);
}