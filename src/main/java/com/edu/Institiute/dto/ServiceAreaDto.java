package com.edu.Institiute.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.ion.Decimal;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAreaDto {
    private String id;
    private ServiceProfessionalDto professionalId;
    private String city;
    private String state;
    private String zipCode;
    private Integer maxDistance;
    private Decimal travelFee;
    private String createdBy;
    private Date createdDate;
    private String modifyBy;
    private Date modifyDate;
    private StatusDto status;
}
