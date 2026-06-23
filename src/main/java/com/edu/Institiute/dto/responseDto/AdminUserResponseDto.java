package com.edu.Institiute.dto.responseDto;

import com.edu.Institiute.dto.StatusDto;
import com.edu.Institiute.entity.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserResponseDto {

    private String adminId;
    private AdminRole role;
    private String permissions;
    private String createdBy;
    private Date createdDate;
    private String modifyBy;
    private Date modifyDate;
    private StatusDto status;
}
