package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.ServiceProfessionalService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/serviceProfessional")
public class ServiceProfessionalController {

    @Autowired
    private ServiceProfessionalService serviceProfessionalService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedServiceProfessional(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = serviceProfessionalService.saveServiceProfessional(data);
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
    @PutMapping("{professionalId}")
    public ResponseEntity<StandardResponse> updateServiceProfessional(@RequestBody RequestRegistryDto data, @PathVariable Long professionalId){
        CommonResponseDto responseData = serviceProfessionalService.updateServiceProfessional(data,professionalId);
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
    @DeleteMapping("{professionalId}")
    public ResponseEntity<StandardResponse> deleteServiceProfessional(@PathVariable Long professionalId){
        CommonResponseDto responseData = serviceProfessionalService.removeServiceProfessional(professionalId);
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
    @GetMapping("{professionalId}")
    public ResponseEntity<StandardResponse> getServiceProfessional(@PathVariable Long professionalId)throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Service Professional List",
                        serviceProfessionalService.serviceProfessionalById(professionalId)),
                HttpStatus.OK
        );
    }


    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllServiceProfessional()throws SQLException{
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "All Service Professional List",
                        serviceProfessionalService.allServiceProfessional()),
                HttpStatus.OK
        );
    }
}
