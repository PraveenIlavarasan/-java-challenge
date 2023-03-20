package jp.co.axa.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.axa.api.constant.ApplicationConstant;
import jp.co.axa.api.dto.EmployeeDTO;
import jp.co.axa.api.entity.Employee;
import jp.co.axa.api.mapper.MapStructObjectMapper;
import jp.co.axa.api.repository.EmployeeRepository;
import jp.co.axa.api.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	MapStructObjectMapper mapper;

	public List<EmployeeDTO> retrieveEmployees() {
		return mapper.toEmployeeDTOList(StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
			    .collect(Collectors.toList()));
	}
	
	public List<EmployeeDTO> getAllEmployeesPageable(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Employee> pagedResult = employeeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return mapper.toEmployeeDTOList(pagedResult.getContent());
        } else {
            return new ArrayList<EmployeeDTO>();
        }
    }

	public EmployeeDTO getEmployee(Long employeeId) {
		
		return mapper.toEmployeeDTO(employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EntityNotFoundException(ApplicationConstant.NO_RECORD + employeeId)));
	}

	public EmployeeDTO saveEmployee(Employee employee) {
		return mapper.toEmployeeDTO(employeeRepository.save(employee));
	}

	public String deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
		return ApplicationConstant.RECORD_DELETE + employeeId;
	}

	public EmployeeDTO updateEmployee(Employee employee, Long employeeId) {
		employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EntityNotFoundException(ApplicationConstant.NO_RECORD + employeeId));

		return mapper.toEmployeeDTO(employeeRepository.save(employee));
	}
}