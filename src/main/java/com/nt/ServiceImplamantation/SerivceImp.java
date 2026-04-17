package com.nt.ServiceImplamantation;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entity.Employee;
import com.nt.dto.EmployeeRequestDto;
import com.nt.dto.EmployeeResponseDto;

import com.nt.repository.EmployeeRepository;
import com.nt.service.EmployeeService;

@Service
public class SerivceImp implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepo;
	
	@Override
	public EmployeeResponseDto add(EmployeeRequestDto employeerequestdto) {
		
		
	Employee emp= new Employee(employeerequestdto.getId(),employeerequestdto.getName(),employeerequestdto.getEmail(),employeerequestdto.getDepartment());
	
     Employee e=employeerepo.save(emp);
    
    return new EmployeeResponseDto(e.getId(),e.getName(),e.getEmail(),e.getDepartment());
        
     
	}
	
	@Override
	public List<EmployeeResponseDto> getAll() {
	
		List<Employee> all = employeerepo.findAll();
		
		List<EmployeeResponseDto> list = new ArrayList<>();
	
		for(Employee emp:all)
		{
			
			EmployeeResponseDto ee= new EmployeeResponseDto(emp.getId(),emp.getName(),emp.getEmail(),emp.getDepartment());
			
			list.add(ee);
			
		}
		
		return list;
	}
	
    @Override
	public EmployeeResponseDto getById(int id) {
	
	Optional<Employee> byId = employeerepo.findById(id);
	
	 if (byId.isPresent()) {
	        Employee e = byId.get();

	        EmployeeResponseDto dto = new EmployeeResponseDto(e.getId(),e.getName(),e.getEmail(),e.getDepartment());
	       
	        return dto;
	    }
		return null;
	}	

     @Override
     public EmployeeResponseDto update(EmployeeRequestDto employeerequestdto) 
     {
	  
	     Employee emp= new Employee(employeerequestdto.getId(),employeerequestdto.getName(),employeerequestdto.getEmail(),employeerequestdto.getDepartment());
		
	     Employee e=employeerepo.save(emp);
	    
	     return new EmployeeResponseDto(e.getId(),e.getName(),e.getEmail(),e.getDepartment());
	        
   }
     
     @Override
     public void delete(int id) {
    	
    	 employeerepo.deleteById(id);
    	
    }
     
     @Override
    public List<EmployeeResponseDto> getByDept(String department) {
    
    	 List<Employee> byDepartment = employeerepo.findByDepartment(department);
    	 List<EmployeeResponseDto> list = new ArrayList<>();
    	 for(Employee emp :byDepartment )
    	 {
    		 EmployeeResponseDto ee= new EmployeeResponseDto(emp.getId(),emp.getName(),emp.getEmail(),emp.getDepartment());
 			
    		 list.add(ee);
    	 }
    	 
    	return list;
    }
}
