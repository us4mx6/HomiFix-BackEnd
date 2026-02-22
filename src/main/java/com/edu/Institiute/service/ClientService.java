package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseCourseDto;

import java.sql.SQLException;

public interface ClientService {
    CommonResponseDto saveClient(RequestRegistryDto dto);
    CommonResponseDto updateClient(RequestRegistryDto dto, String clientId);

    CommonResponseDto removeClient(String clientId);

//    PaginatedResponseCourseDto courseById(String courseCode) throws SQLException;
//
//    PaginatedResponseCourseDto allCourse() throws SQLException;
}
