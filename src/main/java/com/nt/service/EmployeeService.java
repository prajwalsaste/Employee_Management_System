package com.nt.service;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import com.nt.dto.EmployeeRequestDto;
import com.nt.dto.EmployeeResponseDto;

public interface EmployeeService {

	
	EmployeeResponseDto add( EmployeeRequestDto employeerequestdto );
    List<EmployeeResponseDto> getAll();
    EmployeeResponseDto getById(int id);
    EmployeeResponseDto update(@RequestBody EmployeeRequestDto employeerequestdto);
    void delete( int id);
    List<EmployeeResponseDto> getByDept( String department);
}
