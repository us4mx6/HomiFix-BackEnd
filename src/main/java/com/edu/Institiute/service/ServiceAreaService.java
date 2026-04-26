package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseClientDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseServiceAreaDto;

import java.sql.SQLException;

public interface ServiceAreaService {
    CommonResponseDto saveServiceArea(RequestRegistryDto dto);

    CommonResponseDto updateServiceArea(RequestRegistryDto dto, String serviceAreaId);

    CommonResponseDto removeServiceArea(String ServiceAreaId);

    PaginatedResponseServiceAreaDto serviceAreaById(String ServiceAreaId) throws SQLException;

    PaginatedResponseServiceAreaDto allServiceAreas() throws SQLException;

}
