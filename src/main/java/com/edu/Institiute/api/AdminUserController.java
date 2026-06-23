package com.edu.Institiute.api;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.service.AdminUserService;
import com.edu.Institiute.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/adminUser")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    public ResponseEntity<StandardResponse> savedAdminUser(@RequestBody RequestRegistryDto data){
        CommonResponseDto responseData = adminUserService.saveAdminUser(data);
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
    @PutMapping("{adminId}")
    public ResponseEntity<StandardResponse> updateAdminUser(@RequestBody RequestRegistryDto data, @PathVariable String adminId){
        CommonResponseDto responseData = adminUserService.updateAdminUser(data, adminId);
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
    @DeleteMapping("{adminId}")
    public ResponseEntity<StandardResponse> deleteAdminUser(@PathVariable String adminId){
        CommonResponseDto responseData = adminUserService.removeAdminUser(adminId);
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
    @GetMapping("{adminId}")
    public ResponseEntity<StandardResponse> getAdminUser(@PathVariable String adminId) throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Admin User List",
                        adminUserService.adminUserById(adminId)),
                HttpStatus.OK
        );
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public ResponseEntity<StandardResponse> getAllAdminUsers() throws SQLException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Admin User List",
                        adminUserService.allAdminUsers()),
                HttpStatus.OK
        );
    }
}
