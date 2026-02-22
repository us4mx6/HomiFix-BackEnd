package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseProfessionalDto;

import java.sql.SQLException;

public interface ServiceProfessionalService {
    CommonResponseDto saveServiceProfessional(RequestRegistryDto dto);
    CommonResponseDto updateServiceProfessional(RequestRegistryDto dto, String serviceProfessionalId);
    CommonResponseDto removeServiceProfessional(String serviceProfessionalId);
    PaginatedResponseProfessionalDto serviceProfessionalById(String serviceProfessionalId) throws SQLException;
    PaginatedResponseProfessionalDto allServiceProfessional() throws SQLException;
}
