package com.edu.Institiute.service;

import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseClientDto;

import java.sql.SQLException;

public interface ClientService {
    CommonResponseDto saveClient(RequestRegistryDto dto);

    CommonResponseDto updateClient(RequestRegistryDto dto, String clientId);

    CommonResponseDto removeClient(String clientId);

    PaginatedResponseClientDto clientById(String clientId) throws SQLException;

    PaginatedResponseClientDto allClients() throws SQLException;
}
