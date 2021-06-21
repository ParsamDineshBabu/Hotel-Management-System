//package com.hotel.FunctionMicro.controller;
//
//import java.security.Principal;
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import javax.websocket.server.PathParam;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.hotel.FunctionMicro.Repository.CategoryRepository;
//import com.hotel.FunctionMicro.Repository.InventoryRepository;
//import com.hotel.FunctionMicro.entity.Category;
//import com.hotel.FunctionMicro.model.*;
//import com.hotel.FunctionMicro.service.*;
//
//@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
//@RestController
//@RequestMapping("/master")
//public class MasterController {
//
//   @Autowired
//   EmployeeService empServiceImpl;
//   
//   @Autowired
//   RoomService roomServiceImpl;
//
//	@Autowired
//	CategoryRepository categoryRepository;
//   
////   @Autowired
////   RegisterService registerServiceImpl;
//   
//   @Autowired
//   InventoryService inventoryServiceImpl;
//
//
//   @ExceptionHandler(value = Exception.class)
//	public ResponseEntity<Object> exception(Exception e) {
//
//		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//    @GetMapping(value = "/test/hm")
//    public String testHm() {
//
//
//        return "Docker set up done!!";
//    }
//    
//	@PostMapping(value = "/save/emp")
//	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto empDto) {
//
//		return new ResponseEntity(empServiceImpl.saveEmployee(empDto), HttpStatus.OK);
//	}
//	
//	@PostMapping(value = "/save/room")
//	public ResponseEntity<String> saveRoom(@RequestBody RoomDto roomDto) {
//		
//		return new ResponseEntity(roomServiceImpl.saveRoom(roomDto), HttpStatus.OK);
//	}
//	@PostMapping(value = "/save/category")
//	public ResponseEntity<String> saveCategory(@RequestBody Category category) {
//
//		return new ResponseEntity(categoryRepository.save(category), HttpStatus.OK);
//	}
//
//        @PutMapping(value = "/update/room")
//	public ResponseEntity<String> updateRoom(@RequestBody RoomDto roomDto) {
//
//
//		return new ResponseEntity(new ReturnResponse(roomServiceImpl.updateRoom(roomDto)), HttpStatus.OK);
//	}
//
//	@PutMapping(value = "/update/category")
//	public ResponseEntity<String> updateCategory(@RequestBody Category category) {
//		Optional<Category> existing = categoryRepository.findById(category.getId());
//		if(existing.isPresent()){
//			Category saved = categoryRepository.save(category);
//			return new ResponseEntity(new ReturnResponse(saved.getName()), HttpStatus.OK);
//		}
//		return new ResponseEntity( new ReturnResponse("Category not found"), HttpStatus.OK);
//	}
//	
////	@PostMapping(value = "/save/register")
////	public ResponseEntity<String> saveEmployee(@RequestBody RegisterDto registerDto) {
////		
////		return new ResponseEntity(registerServiceImpl.saveEmployee(registerDto), HttpStatus.OK);
////	}
//	
//	@PostMapping(value = "/save/inventory")
//	public ResponseEntity<String> saveInventory(@RequestBody InventoryDto inventoryDto) {
//		
//		return new ResponseEntity( new ReturnResponse(inventoryServiceImpl.saveInventory(inventoryDto)), HttpStatus.OK);
//	}
//    @PutMapping(value = "/update/inventory")
//    public ResponseEntity<String> updateInventory(@RequestBody InventoryDto inventoryDto) {
//        Optional<InventoryDto> existing = Optional.ofNullable(inventoryServiceImpl.findById(inventoryDto.getId()));
//        if(existing.isPresent()){
//            String saved = inventoryServiceImpl.saveInventory(inventoryDto);
//            return new ResponseEntity(new ReturnResponse(saved), HttpStatus.OK);
//        }
//        return new ResponseEntity( new ReturnResponse("Category not found"), HttpStatus.OK);
//    }
//    @PutMapping(value = "/update/emp")
//    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto employeeDto) {
//        Optional<EmployeeDto> existing = Optional.ofNullable(empServiceImpl.findById(employeeDto.getId()));
//        if(existing.isPresent()){
//            String saved = empServiceImpl.saveEmployee(employeeDto);
//            return new ResponseEntity(new ReturnResponse(saved), HttpStatus.OK);
//        }
//        return new ResponseEntity( new ReturnResponse("Category not found"), HttpStatus.OK);
//    }
//	
////	@GetMapping(value="/search/rooms")
////	public ResponseEntity<List<RoomDto>> searchRooms() throws ParseException {
//////   	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//////		Date requiredCheckin = simpleDateFormat.parse(checkin);
//////		Date requiredCheckout = simpleDateFormat.parse(checkout);
////		return new ResponseEntity(roomServiceImpl.searchRooms(), HttpStatus.OK);
////		
////	}
//	
//	@GetMapping(value="/search/rooms/{checkin}/{checkout}")
//	public ResponseEntity<List<RoomDto>> searchRooms(@PathVariable String checkin, @PathVariable String checkout) throws ParseException {
//   	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date requiredCheckin = simpleDateFormat.parse(checkin);
//		Date requiredCheckout = simpleDateFormat.parse(checkout);
//		return new ResponseEntity(roomServiceImpl.searchRooms(requiredCheckin, requiredCheckout), HttpStatus.OK);
//		
//	}
//	
//	@GetMapping(value="/getAll/rooms")
//    public ResponseEntity<List<RoomDto>> getAllRooms(){
//		return new ResponseEntity(roomServiceImpl.getAllRooms(), HttpStatus.OK);
//		
//	}
//	@GetMapping(value="/getAll/categories")
//	public ResponseEntity<List<CategoryDto>> getAllCategories(){
//		return new ResponseEntity(categoryRepository.findAll(), HttpStatus.OK);
//
//	}
//	
//	@GetMapping(value="/getAll/emp")
//    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
//		return new ResponseEntity(empServiceImpl.getAllEmployee(), HttpStatus.OK);
//		
//	}
//	
//	@GetMapping(value="/getemp/byid/{id}")
//    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable String id){
//		return new ResponseEntity(empServiceImpl.findById(id), HttpStatus.OK);
//		
//	}
//	
//	@DeleteMapping(value="/deleteemp/byid/{id}")
//    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id){
//		String success=empServiceImpl.deleteEmployeeById(id);
//		return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
//		
//	}
//	@DeleteMapping(value="/deleteCategory/byid/{id}")
//	public ResponseEntity<String> deleteCategoryById(@PathVariable String id){
//		categoryRepository.deleteById(id);
//		return new ResponseEntity(new ReturnResponse(id), HttpStatus.OK);
//
//	}
//	
//	@GetMapping(value="/getroom/byid/{id}")
//    public ResponseEntity<EmployeeDto> findRoomById(@PathVariable String id){
//		return new ResponseEntity(roomServiceImpl.findById(id), HttpStatus.OK);
//		
//	}
//	
//	@DeleteMapping(value="/deleteroom/byid/{id}")
//    public ResponseEntity<String> deleteRoomById(@PathVariable String id){
//		String success=roomServiceImpl.deleteRoomById(id);
//		return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
//		
//	}
//	
//	@GetMapping(value="/getAll/inventory")
//    public ResponseEntity<List<InventoryDto>> getAllInventory(){
//		return new ResponseEntity(inventoryServiceImpl.getAllInventory(), HttpStatus.OK);
//		
//	}
//	
//	@GetMapping(value="/getinventory/byid/{id}")
//    public ResponseEntity<EmployeeDto> findInventoryById(@PathVariable String id){
//		return new ResponseEntity(inventoryServiceImpl.findById(id), HttpStatus.OK);
//		
//	}
//	
//	@DeleteMapping(value="/deleteinventory/byid/{id}")
//    public ResponseEntity<String> deleteInventoryById(@PathVariable String id){
//		String success=inventoryServiceImpl.deleteInventoryById(id);
//		return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
//		
//	}
//
////	@GetMapping(value="/getAll/registerd")
////    public ResponseEntity<List<RegisterDto>> getAllRegistered(){
////		return new ResponseEntity(registerServiceImpl.getAllRegistered(), HttpStatus.OK);
////		
////	}
////	
////	@GetMapping(value="/getregistered/byid/{id}")
////    public ResponseEntity<RegisterDto> findRegisterById(@PathVariable String id){
////		return new ResponseEntity(registerServiceImpl.findById(id), HttpStatus.OK);
////		
////	}
////	
////	@DeleteMapping(value="/deleteregistered/byid/{id}")
////    public ResponseEntity<String> deleteRegisteredById(@PathVariable String id){
////		String success=registerServiceImpl.deleteRegisterById(id);
////		return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
////		
////	}
////	@PostMapping(value="/check/validuser/{email}/{password}")
////    public ResponseEntity<RegisterDto> findRegisterById(@PathVariable String email,@PathVariable String password){
////		return new ResponseEntity(registerServiceImpl.findByEmailAndPassword(email, password), HttpStatus.OK);
////		
////	}
//	
//}
