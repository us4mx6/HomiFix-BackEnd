package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.ClientService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedClient(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = clientService.saveClient(data);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("{clientId}")
    public ResponseEntity<StandardResponse> updateCourse(@RequestBody RequestRegistryDto data, @PathVariable String clientId){
        CommonResponseDto responseData = clientService.updateClient(data,clientId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("{clientId}")
    public ResponseEntity<StandardResponse> deleteCourse(@PathVariable String clientId){
        CommonResponseDto responseData = clientService.removeClient(clientId);
        return new ResponseEntity<>(
                new StandardResponse(
                        responseData.getCode(),
                        responseData.getMessage(),
                        responseData.getData()
                ),
                HttpStatus.CREATED
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("{clientId}")
    public ResponseEntity<StandardResponse> getCourse(@PathVariable String clientId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Client List",
                        clientService.clientById(clientId)),
                HttpStatus.OK
        );
    }


    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllStudents()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Client List",
                        clientService.allClients()),
                HttpStatus.OK
        );
    }

}
