package com.hotel.FunctionMicro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.FunctionMicro.model.EmployeeDto;
import com.hotel.FunctionMicro.model.ReturnResponse;
import com.hotel.FunctionMicro.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/master")
@SuppressWarnings({"rawtypes","unchecked"})
public class EmployeeController {

   @Autowired
   EmployeeService empServiceImpl;
   
   
   
   @ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
   
	/* Creating Employee in MongoDB whose collection name is Employee  */

	@ApiOperation(value = "It Will Create Employee",notes="this just create employee")
	@PostMapping(value = "/save/emp")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto empDto) {

		return new ResponseEntity(empServiceImpl.saveEmployee(empDto), HttpStatus.OK);
	}
	
	/* Reading details which belongs to Employee in MongoDB whose collection name is Employee */

	@ApiOperation(value = "It Will Provide all Employee Details ")
	@GetMapping(value="/getAll/emp")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		return new ResponseEntity(empServiceImpl.getAllEmployee(), HttpStatus.OK);
		
	}
	
	/* Reading particular Employee data which belongs to Employee in MongoDB whose collection name is Employee */

	@ApiOperation(value = "It Will Provide Employee Details with the help of ID")
	@GetMapping(value="/getemp/byid/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable String id){
		return new ResponseEntity(empServiceImpl.findById(id), HttpStatus.OK);
		
	}
	
	/* Updating Employee in MongoDB whose collection name is Employee */

	@ApiOperation(value = "It Will Update the Employee Details")
	@PutMapping(value = "/update/emp")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        Optional<EmployeeDto> existing = Optional.ofNullable(empServiceImpl.findById(employeeDto.getId()));
        if(existing.isPresent()){
            String saved = empServiceImpl.saveEmployee(employeeDto);
            return new ResponseEntity(new ReturnResponse(saved), HttpStatus.OK);
        }
        return new ResponseEntity( new ReturnResponse("Category not found"), HttpStatus.OK);
    }
	
	/* Deleting Employee in MongoDB where collection name is Employee */

	@ApiOperation(value = "It Will Delete the Employee Details with Id")
	@DeleteMapping(value="/deleteemp/byid/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id){
		String success=empServiceImpl.deleteEmployeeById(id);
		return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
		
	}
	@GetMapping(value = "/test/emp")
    public String testemp() {
     return "Employee set up done!!";
   }
}
