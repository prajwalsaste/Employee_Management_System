package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.ServiceImplamantation.SerivceImp;
import com.nt.dto.EmployeeRequestDto;
import com.nt.dto.EmployeeResponseDto;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
    	@Autowired
	    SerivceImp serviceimp;
	
	    @GetMapping("/")
	   public String healthCheck(){
	    	
		return "ok";
	      }

	
	     @PostMapping("/add")
	    public EmployeeResponseDto add(@RequestBody EmployeeRequestDto employeerequestdto ) {
	    	 
	    	return serviceimp.add(employeerequestdto);
	    }
	     
	     @GetMapping("/all")
	     public List<EmployeeResponseDto> getAll() 
	     {
	    	
	    	 return  serviceimp.getAll();
	     }
	     
	     
	     @GetMapping("/getbyid/{id}")
	     public EmployeeResponseDto getById(@PathVariable int id) {
	    	 
	    	 
	         return serviceimp.getById(id);
	     }
	     
	     @PutMapping("/update")
	     public EmployeeResponseDto update(@RequestBody EmployeeRequestDto employeerequestdto) {
	         return serviceimp.update(employeerequestdto);
	     }
	     
	     
	     @DeleteMapping("/delete/{id}")
	     public String delete(@PathVariable int id) {
	    	 serviceimp.delete(id);
	    	 
	         return "Deleted Successfully";
	     }
	     
	     @GetMapping("/department/{department}")
	     public List<EmployeeResponseDto> getByDept(@PathVariable String department) {
	         return serviceimp.getByDept(department);
	     }
}
