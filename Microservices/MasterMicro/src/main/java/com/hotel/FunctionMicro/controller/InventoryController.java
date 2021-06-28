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
import com.hotel.FunctionMicro.model.InventoryDto;
import com.hotel.FunctionMicro.model.ReturnResponse;
import com.hotel.FunctionMicro.service.InventoryService;

import io.swagger.annotations.ApiOperation;
@CrossOrigin
@RestController
@RequestMapping("/master")
@SuppressWarnings({"rawtypes","unchecked"})
public class InventoryController {
	   @Autowired
	   InventoryService inventoryServiceImpl;
	   
	   @ExceptionHandler(value = Exception.class)
		public ResponseEntity<Object> exception(Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	   
		/* Creating Inventory in MongoDB whose collection name is Inventory  */

		@ApiOperation(value = "It Will Create Inventory",notes="this just create Inventory")
		@PostMapping(value = "/save/inventory")
		public ResponseEntity<String> saveInventory(@RequestBody InventoryDto inventoryDto) {
			
			return new ResponseEntity( new ReturnResponse(inventoryServiceImpl.saveInventory(inventoryDto)), HttpStatus.OK);
		}
		
		/* Reading details which belongs to Inventory in MongoDB whose collection name is Inventory */

		@ApiOperation(value = "It Will Provide all Inventory Details ")
		@GetMapping(value="/getAll/inventory")
	    public ResponseEntity<List<InventoryDto>> getAllInventory(){
			return new ResponseEntity(inventoryServiceImpl.getAllInventory(), HttpStatus.OK);
			
		}
		
		/* Reading particular Inventory data which belongs to Inventory in MongoDB whose collection name is Inventory */

		@ApiOperation(value = "It Will Provide Inventory Details with the help of ID")
		@GetMapping(value="/getinventory/byid/{id}")
	    public ResponseEntity<EmployeeDto> findInventoryById(@PathVariable String id){
			return new ResponseEntity(inventoryServiceImpl.findById(id), HttpStatus.OK);
			
		}
		
		/* Updating Inventory in MongoDB whose collection name is Inventory */

		@ApiOperation(value = "It Will Update the Inventory Details")
	    @PutMapping(value = "/update/inventory")
	    public ResponseEntity<String> updateInventory(@RequestBody InventoryDto inventoryDto) {
	        Optional<InventoryDto> existing = Optional.ofNullable(inventoryServiceImpl.findById(inventoryDto.getId()));
	        if(existing.isPresent()){
	            String saved = inventoryServiceImpl.saveInventory(inventoryDto);
	            return new ResponseEntity(new ReturnResponse(saved), HttpStatus.OK);
	        }
	        return new ResponseEntity( new ReturnResponse("Category not found"), HttpStatus.OK);
	    }
		
		/* Deleting Inventory in MongoDB where collection name is Inventory */

		@ApiOperation(value = "It Will Delete the Inventory Details with Id")
		@DeleteMapping(value="/deleteinventory/byid/{id}")
	    public ResponseEntity<String> deleteInventoryById(@PathVariable String id){
			String success=inventoryServiceImpl.deleteInventoryById(id);
			return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
			
		}


}
