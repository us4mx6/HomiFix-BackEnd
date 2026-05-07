package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.ClientDto;
import com.edu.Institiute.dto.ServiceAreaDto;
import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.ServiceArea;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface ServiceAreaMapper {
    ServiceArea dtoToServiceAreaEntity(ServiceAreaDto serviceAreaDto);

}
