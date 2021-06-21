package com.hotel.FunctionMicro.controller;
//package com.hotel.MasterMicro.controller;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.hotel.MasterMicro.model.ReturnResponse;
//import com.hotel.MasterMicro.model.RoomModel;
//import com.hotel.MasterMicro.service.RoomService;
//
//import io.swagger.annotations.ApiOperation;
//
//import java.text.ParseException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
////@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
//@RestController
//@RequestMapping("/master")
//@SuppressWarnings({"unchecked","rawtypes"})
//public class Controller {
//	
//	    @Autowired
//	    RoomService roomServiceImpl;
//	
//			
//	    @GetMapping("/room")
//	    public String room() {
//	        return "Room is working";
//	    }
//	    
//		/* Creating Room in MongoDB whose collection is rooms */
//	    
//		@ApiOperation(value = "It Will Create Room",notes="this just create room")
//		@PostMapping(value = "/save/room")
//		public ResponseEntity<String> createRoom(@RequestBody RoomModel roomDto) {
//			
//			return new ResponseEntity(roomServiceImpl.createRoom(roomDto), HttpStatus.CREATED);
//		}
//	
//		/* Reading details which belongs to Room in MongoDB whose collection is rooms */
//		
//		@ApiOperation(value = "It Will Provide all Room Details ")
//		@GetMapping(value="/getAll/rooms")
//		public ResponseEntity<List<RoomModel>> getAllRooms(){
//			return new ResponseEntity(roomServiceImpl.getAllRooms(), HttpStatus.OK);
//			
//		}
//		
//		/* Reading particular room data which belongs to Room in MongoDB whose collection is rooms */
//		
//		@ApiOperation(value = "It Will Provide Room Details with the help of ID")
//		@GetMapping(value="/getroom/byid/{id}")
//		
//		  public ResponseEntity<String> findRoomById(@PathVariable String id){ 
//			
//			HttpHeaders head =new HttpHeaders();
//			head.set("ResponseHeader", "Successfully Excuted");
//			return new ResponseEntity(roomServiceImpl.findById(id), head, HttpStatus.OK);
//		  
//		  }
//		 
//		/* Updating Room in MongoDB whose collection is rooms */
//
//		@ApiOperation(value = "It Will Update the Room Details")
//		@PutMapping(value = "/update/room")
//		public ResponseEntity<String> updateRoom(@RequestBody RoomModel roomDto) {
//
//			return new ResponseEntity(roomServiceImpl.updateRoom(roomDto), HttpStatus.OK);
//		}
//		
//		/* Deleting Room in MongoDB where collection is rooms */
//		
//		@ApiOperation(value = "It Will Delete the Room Details with Id")
//		@DeleteMapping(value="/deleteroom/byid/{id}")
//	    public ResponseEntity<String> deleteRoomById(@PathVariable String id){
//			String success=roomServiceImpl.deleteRoomById(id);
//			return new ResponseEntity("sucess", HttpStatus.OK);
//			
//		}
//		
//		@GetMapping(value="/search/rooms")
//		public ResponseEntity<List<RoomModel>> searchRooms() throws ParseException {
////	   	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
////			Date requiredCheckin = simpleDateFormat.parse(checkin);
////			Date requiredCheckout = simpleDateFormat.parse(checkout);
//			return new ResponseEntity(roomServiceImpl.searchRooms(), HttpStatus.OK);
//			
//		}
//
//}