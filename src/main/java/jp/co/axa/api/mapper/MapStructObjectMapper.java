package jp.co.axa.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import jp.co.axa.api.dto.EmployeeDTO;
import jp.co.axa.api.entity.Employee;

@Mapper(componentModel = "spring")
public interface MapStructObjectMapper {
	
	MapStructObjectMapper MAPPER = Mappers.getMapper(MapStructObjectMapper.class);

	
	public EmployeeDTO toEmployeeDTO(Employee employee);
	
	public Employee toEmployee(EmployeeDTO employeeDTO);
	
	public List<EmployeeDTO> toEmployeeDTOList(List<Employee> employee);
	
	public List<Employee> toEmployeeList(List<EmployeeDTO> employeeDTO);

}