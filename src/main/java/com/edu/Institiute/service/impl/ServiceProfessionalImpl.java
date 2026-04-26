package com.edu.Institiute.service.impl;

import com.edu.Institiute.config.SecurityUtil;
import com.edu.Institiute.dto.ServiceProfessionalDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.ServiceProfessionalResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseProfessionalDto;
import com.edu.Institiute.entity.ServiceProfessional;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.ServiceProfessionalRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.service.ServiceProfessionalService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.ServiceProfessionalMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceProfessionalImpl implements ServiceProfessionalService {

    @Autowired
    private Generator generator;

    @Autowired
    private ServiceProfessionalMapper serviceProfessionalMapper;

    @Autowired
    private ServiceProfessionalRepo serviceProfessionalRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Override
    public CommonResponseDto saveServiceProfessional(RequestRegistryDto dto) {

        try {
            Long professionalId = generator.generateFourLongNumbers();
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
            String loggedUser = SecurityUtil.getLoggedUser();
            String createdBy = (loggedUser != null) ? loggedUser : dto.getCreatedBy();

            ServiceProfessionalDto serviceProfessionalDto = new ServiceProfessionalDto(
                    professionalId,
                    dto.getBusinessName(),
                    dto.getBusinessRegistrationNumber(),
                    dto.getBusinessAddress(),
                    dto.getDescription(),
                    dto.getYearsOfExperience(),
                    dto.getIsVerified(),
                    dto.getVerificationDate(),
                    dto.getOverallRating(),
                    dto.getTotalJobsCompleted(),
                    dto.getResponseRate(),
                    dto.getAvgResponseTime(),
                    createdBy,
                    new Date(),
                    "",
                    null,
                    statusMapper.toStatusDto(status.get())

            );
            serviceProfessionalRepo.save(serviceProfessionalMapper.dtoToServiceProfessionalEntity(serviceProfessionalDto));

            return new CommonResponseDto(201, "Service Professional  saved!", serviceProfessionalDto.getProfessionalId(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateServiceProfessional(RequestRegistryDto dto, Long professionalId) {
        try {

            String loggedUser = SecurityUtil.getLoggedUser();
            String modifyBy = (loggedUser != null) ? loggedUser : dto.getCreatedBy();

            ServiceProfessional allServiceProfessional = serviceProfessionalRepo.getServiceProfessionalByProvidedId(professionalId);
            allServiceProfessional.setBusinessName(dto.getBusinessName());
            allServiceProfessional.setBusinessRegistrationNumber(dto.getBusinessRegistrationNumber());
            allServiceProfessional.setBusinessAddress(dto.getBusinessAddress());
            allServiceProfessional.setDescription(dto.getDescription());
            allServiceProfessional.setYearsOfExperience(dto.getYearsOfExperience());
            allServiceProfessional.setIsVerified(dto.getIsVerified());
            allServiceProfessional.setVerificationDate(dto.getVerificationDate());
            allServiceProfessional.setOverallRating(dto.getOverallRating());
            allServiceProfessional.setTotalJobsCompleted(dto.getTotalJobsCompleted());
            allServiceProfessional.setResponseRate(dto.getResponseRate());
            allServiceProfessional.setAvgResponseTime(dto.getAvgResponseTime());
            allServiceProfessional.setModifyBy(modifyBy);
            allServiceProfessional.setModifyDate(new Date());

            serviceProfessionalRepo.save(allServiceProfessional);
            return new CommonResponseDto(201, "Service Professional Updated!", allServiceProfessional.getProfessionalId(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeServiceProfessional( Long professionalId) {
        Optional<ServiceProfessional> serviceProfessional = serviceProfessionalRepo.findByServiceProfessionalId(professionalId);

        if (serviceProfessional.isPresent()) {
            serviceProfessionalRepo.delete(serviceProfessional.get());
            return new CommonResponseDto(201, "Service Professional was deleted!", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any client...!");
        }
    }

    @Override
    public PaginatedResponseProfessionalDto serviceProfessionalById( Long professionalId) throws SQLException {
        try {
            List<ServiceProfessional> serviceProfessionals = serviceProfessionalRepo.getAllServiceProfessionalById(professionalId);
            List<ServiceProfessionalResponseDto> serviceProfessionalDto = new ArrayList<>();

            for (ServiceProfessional r : serviceProfessionals) {
                serviceProfessionalDto.add(
                        new ServiceProfessionalResponseDto(
                                r.getProfessionalId(),
                                r.getBusinessName(),
                                r.getBusinessRegistrationNumber(),
                                r.getBusinessAddress(),
                                r.getDescription(),
                                r.getYearsOfExperience(),
                                r.getIsVerified(),
                                r.getVerificationDate(),
                                r.getOverallRating(),
                                r.getTotalJobsCompleted(),
                                r.getResponseRate(),
                                r.getAvgResponseTime(),
                                r.getCreatedBy(),
                                r.getCreatedDate(),
                                r.getModifyBy(),
                                r.getModifyDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }
            return new PaginatedResponseProfessionalDto(
                    serviceProfessionalRepo.count(),
                    serviceProfessionalDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }
    }

    @Override
    public PaginatedResponseProfessionalDto allServiceProfessional() throws SQLException {
        try {
            List<ServiceProfessional> allServiceProfessionals = serviceProfessionalRepo.getAllServiceProfessional();
            List<ServiceProfessionalResponseDto> serviceProfessionalDto = new ArrayList<>();

            for (ServiceProfessional r : allServiceProfessionals) {
                serviceProfessionalDto.add(
                        new ServiceProfessionalResponseDto(
                                r.getProfessionalId(),
                                r.getBusinessName(),
                                r.getBusinessRegistrationNumber(),
                                r.getBusinessAddress(),
                                r.getDescription(),
                                r.getYearsOfExperience(),
                                r.getIsVerified(),
                                r.getVerificationDate(),
                                r.getOverallRating(),
                                r.getTotalJobsCompleted(),
                                r.getResponseRate(),
                                r.getAvgResponseTime(),
                                r.getCreatedBy(),
                                r.getCreatedDate(),
                                r.getModifyBy(),
                                r.getModifyDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }
            return new PaginatedResponseProfessionalDto(
                    serviceProfessionalRepo.count(),
                    serviceProfessionalDto
            );
        }catch (Exception e){
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
