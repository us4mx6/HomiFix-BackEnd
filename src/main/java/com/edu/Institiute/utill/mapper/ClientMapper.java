package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.ClientDto;
import com.edu.Institiute.entity.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client dtoToClientEntity(ClientDto clientDto);

    ClientDto toClientDto(Client client);
}
