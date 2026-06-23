package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseAdminUserDto;

import java.sql.SQLException;

public interface AdminUserService {

    CommonResponseDto saveAdminUser(RequestRegistryDto dto);
    CommonResponseDto updateAdminUser(RequestRegistryDto dto, String adminId);
    CommonResponseDto removeAdminUser(String adminId);
    PaginatedResponseAdminUserDto adminUserById(String adminId) throws SQLException;
    PaginatedResponseAdminUserDto allAdminUsers() throws SQLException;

}
