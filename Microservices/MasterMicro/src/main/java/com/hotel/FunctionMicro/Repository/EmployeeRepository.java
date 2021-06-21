package com.hotel.FunctionMicro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.FunctionMicro.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
