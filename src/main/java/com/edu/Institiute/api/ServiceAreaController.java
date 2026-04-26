package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.ServiceAreaService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/serviceArea")
public class ServiceAreaController {

    @Autowired
    private ServiceAreaService serviceAreaService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedServiceArea(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = serviceAreaService.saveServiceArea(data);
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
    @PutMapping("{serviceAreaId}")
    public ResponseEntity<StandardResponse> updateServiceArea(@RequestBody RequestRegistryDto data, @PathVariable String serviceAreaId){
        CommonResponseDto responseData = serviceAreaService.updateServiceArea(data,serviceAreaId);
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
    @DeleteMapping("{serviceAreaId}")
    public ResponseEntity<StandardResponse> deleteServiceArea(@PathVariable String serviceAreaId){
        CommonResponseDto responseData =serviceAreaService.removeServiceArea(serviceAreaId);
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
    @GetMapping("{serviceAreaId}")
    public ResponseEntity<StandardResponse> getServiceArea(@PathVariable String serviceAreaId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "serviceArea List",
                        serviceAreaService.serviceAreaById(serviceAreaId)),
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllServiceArea()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Client List",
                        serviceAreaService.allServiceAreas()),
                HttpStatus.OK
        );
    }

}