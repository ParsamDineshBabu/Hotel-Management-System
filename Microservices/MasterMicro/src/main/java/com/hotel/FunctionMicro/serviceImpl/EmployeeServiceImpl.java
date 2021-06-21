package com.hotel.FunctionMicro.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.FunctionMicro.Repository.EmployeeRepository;
import com.hotel.FunctionMicro.entity.Employee;
import com.hotel.FunctionMicro.entity.Room;
import com.hotel.FunctionMicro.model.EmployeeDto;
import com.hotel.FunctionMicro.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;

	public String saveEmployee(EmployeeDto empDto) {
		
		Employee emp = new Employee(empDto.getId(),empDto.getName(),empDto.getEmpId(),empDto.getEmail(),empDto.getContactNo(),
				empDto.getSalary(),empDto.getDob(),empDto.getJoinDate(),empDto.getEndDate(),empDto.getRole());
		
		empRepository.save(emp);
		return empDto.getEmpId();
	}
	
	public List<EmployeeDto> getAllEmployee(){
		
		List<Employee> empList= empRepository.findAll();
		
		List<EmployeeDto> result = new ArrayList<EmployeeDto>();
		if(!empList.isEmpty()) {
			for(Employee s:empList){
				EmployeeDto empDto = new EmployeeDto(s.getId(),s.getName(),s.getEmpId(),s.getEmail(),s.getContactNo(),
						s.getSalary(),s.getDob(),s.getJoinDate(),s.getEndDate());
				result.add(empDto);
			}
		}
	return result;
	}
	
	public EmployeeDto findById(String id) {
		
		EmployeeDto empDto = null;
		Optional<Employee> emp = empRepository.findById(id);
		
		if(emp.isPresent()) {
			Employee s =emp.get();
			empDto = new EmployeeDto(s.getId(),s.getName(),s.getEmpId(),s.getEmail(),s.getContactNo(),
					s.getSalary(),s.getDob(),s.getJoinDate(),s.getEndDate());
		}
		
	    return empDto;	
	
	}
	
	public String deleteEmployeeById(String id) {
		empRepository.deleteById(id);
		return "emp deleted";
	}

	@Override
	public String updateEmployee(EmployeeDto empDto) {
		Optional<Employee> room = empRepository.findById(empDto.getId());
		System.out.println("**************UPdating"+empDto.getEmpId());
		Employee updatedEmployee = null;
		if(room.isPresent()){
			Employee emp = new Employee(empDto.getId(),empDto.getName(),empDto.getEmpId(),empDto.getEmail(),empDto.getContactNo(),
					empDto.getSalary(),empDto.getDob(),empDto.getJoinDate(),empDto.getEndDate(),
					empDto.getRole());

			empRepository.save(emp);
			return emp.getEmpId();
		}else{
			return "Unable to fnd employee";
		}

	}

}
