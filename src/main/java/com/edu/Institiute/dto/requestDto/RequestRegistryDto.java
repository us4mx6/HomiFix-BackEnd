package com.edu.Institiute.dto.requestDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import software.amazon.ion.Decimal;

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

    //ServiceProfessional
//    private String businessName;
//    private String businessRegistrationNumber;
//    private String businessAddress;
//    private String description;
//    private String yearsOfExperience;
//    private Boolean isVerified;
//    private Date verificationDate;
//    private Long overallRating;
//    private Integer totalJobsCompleted;
//    private Long responseRate;
//    private String avgResponseTime;

    //ServiceArea
    private Long professionalId;
    private String city;
    private String state;
    private String zipCode;
    private Integer maxDistance;
    private Decimal travelFee;
}
