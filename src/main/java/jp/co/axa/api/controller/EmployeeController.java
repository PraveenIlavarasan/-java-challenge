package jp.co.axa.api.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jp.co.axa.api.dto.EmployeeDTO;
import jp.co.axa.api.entity.Employee;
import jp.co.axa.api.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@Api(value = "Employee", description = "This controller is for Employee data operation")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 409, message = "Conflict occurred") })
public class EmployeeController {

	private static final Logger logger = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	
	/**
	 * Retrieves a paginated list of all employees from the database
	 *
	 * @param pageNo   The page number to retrieve (starting from 0)
	 * @param pageSize The number of employees to include per page
	 * @param sortBy   The field to sort the employees by (default is "id")
	 * @return A paginated list of employees
	 */

	@GetMapping("")
	@ApiOperation(value = "This api is used to get all records of Employee", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeesPagable(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "20") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		List<EmployeeDTO> list = employeeService.getAllEmployeesPageable(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<EmployeeDTO>>(list, HttpStatus.OK);
	}

	/**
	 * Retrieves an employee by ID
	 * 
	 * @param employeeId ID of the employee to retrieve
	 * @return The employee with the specified ID
	 */
	
	@GetMapping("/{employeeId}")
	@ApiOperation(value = "This api is used to get Employee record by id", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		logger.info("Initiating getEmployee id:" + employeeId);
		EmployeeDTO employee = employeeService.getEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	/**
	 * Creates a new employee
	 * 
	 * @param employee The employee to create
	 * @return The created employee
	 */

	@PostMapping("")
	@ApiOperation(value = "This api is used to save an Employee record", notes = "Returns HTTP 201 if successful get the record")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody Employee employee) {
		logger.info("Initiating saveEmployee");
		EmployeeDTO employeeObj = employeeService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(employeeObj);
	}
	
	/**
	 * Deletes an employee by ID
	 * 
	 * @param employeeId ID of the employee to delete
	 */

	@DeleteMapping("/{employeeId}")
	@ApiOperation(value = "This api is used to delete an Employee record", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		logger.info("Initiating deleteEmployee id:" + employeeId);
		String message = employeeService.deleteEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	/**
	 * Updates an employee by ID
	 * 
	 * @param employeeId ID of the employee to update
	 * @param employee Details of the employee to update
	 * @return The updated employee
	 */

	@PutMapping("/{employeeId}")
	@ApiOperation(value = "This api is used to update an Employee record", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Employee employee,
			@PathVariable(name = "employeeId") Long employeeId) {
		logger.info("Initiating updateEmployee id:" + employeeId);
		EmployeeDTO employeeObj = employeeService.updateEmployee(employee, employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(employeeObj);

	}

}
