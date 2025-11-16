package com.edu.Institiute.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RequestRegistryDto {

    private String studentCode;
    private String studentName;
    private String studentAge;
    private String studentNic;
    private Integer status;

    private String courseCode;
    private String courseName;

    // Client - Request
    private String homeAddress;
    private String preferredContactMethod;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String createdBy;
    private Date createdDate;
    private String modifyBy;
    private Date modifyDate;
}
