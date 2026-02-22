package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProfessionalResponseDto {

    private Long professionalId;
    private String businessName;
    private String businessRegistrationNumber;
    private String businessAddress;
    private String description;
    private String yearsOfExperience;
    private Boolean isVerified;
    private Date verificationDate;
    private Long overallRating;
    private Integer totalJobsCompleted;
    private Long responseRate;
    private String avgResponseTime;
    private String createdBy;
    private Date createdDate;
    private String modifyBy;
    private Date modifyDate;
    private StatusDto status;
}
