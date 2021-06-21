package com.hotel.FunctionMicro.service;

import java.util.List;

import com.hotel.FunctionMicro.model.EmployeeDto;


public interface EmployeeService {

	public String saveEmployee(EmployeeDto staffDto);
	
	public List<EmployeeDto> getAllEmployee();
	
	public EmployeeDto findById(String id);
	
	public String deleteEmployeeById(String id);

	public String updateEmployee(EmployeeDto staffDto);
}
