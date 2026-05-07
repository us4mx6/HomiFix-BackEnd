package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.ServiceProfessionalDto;
import com.edu.Institiute.entity.ServiceProfessional;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface ServiceProfessionalMapper {
    ServiceProfessional dtoToServiceProfessionalEntity(ServiceProfessionalDto serviceProfessionalDto);
    ServiceProfessionalDto toServiceProfessionalDto(ServiceProfessional serviceProfessional);
}
