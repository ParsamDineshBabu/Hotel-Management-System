package com.hotel.FunctionMicro;


import com.hotel.FunctionMicro.controller.EmployeeController;
import com.hotel.FunctionMicro.controller.RoomController;
import com.hotel.FunctionMicro.model.EmployeeDto;
import com.hotel.FunctionMicro.model.ReturnResponse;
import com.hotel.FunctionMicro.model.RoomDto;
import com.hotel.FunctionMicro.service.EmployeeService;
import com.hotel.FunctionMicro.service.RoomService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@SuppressWarnings({"rawtypes","unchecked"})
public class FunctionMicroApplicationTests {

    @InjectMocks
    EmployeeController empController;
    
    @InjectMocks
    RoomController roomController;

    @Mock
    EmployeeService empServiceImpl;

    @Mock
    RoomService roomServiceImpl;





    @Test
    public void contextLoads() {
        Assert.assertEquals("Employee set up done!!",empController.testemp());
    }

    @Test
    public  void testSaveEmployee(){
        Mockito.when(empServiceImpl.saveEmployee(Mockito.any())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity("Success", HttpStatus.OK),empController.saveEmployee(Mockito.any()));
    }
    @Test
    public  void testSaveRoom(){
        Mockito.when(roomServiceImpl.saveRoom(Mockito.any())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity("Success", HttpStatus.OK),roomController.saveRoom(Mockito.any()));
    }

    @Test
    public  void  testgetAllRooms(){
        RoomDto roomDto = new RoomDto();
        roomDto.setId("room");
        Mockito.when(roomServiceImpl.getAllRooms()).thenReturn(Stream.of(roomDto).collect(Collectors.toList()));

        Assert.assertNotNull(roomController.getAllRooms());

    }
    

//    @Test
//    public void testGetAllCategories(){
//        Category categoryDto = new Category();
//        categoryDto.setId("123");
//        Mockito.when(categoryRepository.findAll()).thenReturn(Stream.of(categoryDto).collect(Collectors.toList()));
//        Assert.assertNotNull(empController.getAllCategories());
//    }

    @Test
    public void testGetAllEmployee(){
        EmployeeDto staffDto = new EmployeeDto();
        staffDto.setId("test");
        Mockito.when(empServiceImpl.getAllEmployee()).thenReturn(Stream.of(staffDto).collect(Collectors.toList()));
        Assert.assertEquals(new ResponseEntity(Stream.of(staffDto).collect(Collectors.toList()), HttpStatus.OK),empController.getAllEmployee());
    }

    @Test
    public void testDeleteRoomById(){
        Mockito.when(roomServiceImpl.deleteRoomById(Mockito.anyString())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity(new ReturnResponse("Success"), HttpStatus.OK),
                roomController.deleteRoomById(Mockito.anyString()));
    }
    @Test
    public void testDeleteEmployeeById(){
        Mockito.when(empServiceImpl.deleteEmployeeById(Mockito.anyString())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity(new ReturnResponse("Success"), HttpStatus.OK),
                empController.deleteEmployeeById(Mockito.anyString()));
    }

    @Test void testUpdateRoom() {
        Mockito.when(roomServiceImpl.updateRoom(Mockito.any())).thenReturn("Success");
        Assert.assertEquals(new ResponseEntity(new ReturnResponse("Success"), HttpStatus.OK),
                roomController.updateRoom(Mockito.any()));
    }

}
