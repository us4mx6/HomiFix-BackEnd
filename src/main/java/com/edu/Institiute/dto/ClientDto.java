package com.edu.Institiute.dto;

import com.edu.Institiute.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

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
