package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

    private String clientId;
    private String homeAddress;
    private String preferredContactMethod;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String createdBy;
    private Date createdDate;
    private String modifyBy;
    private Date modifyDate;
    private StatusDto status;
}
