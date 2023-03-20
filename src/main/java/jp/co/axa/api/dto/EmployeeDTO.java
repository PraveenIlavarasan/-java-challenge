package jp.co.axa.api.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	    private Long id;

	    private String name;

	    private Integer salary;

	    private String department;
	    
	    private String createdBy;

	    private Date createdAt;

	    private String updatedBy;

	    private Date updatedAt;

}