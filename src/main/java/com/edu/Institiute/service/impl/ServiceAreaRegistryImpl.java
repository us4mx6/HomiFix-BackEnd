//package com.edu.Institiute.service.impl;
//import com.edu.Institiute.config.SecurityUtil;
//import com.edu.Institiute.dto.ServiceAreaDto;
//import com.edu.Institiute.dto.StatusDto;
//import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
//import com.edu.Institiute.dto.responseDto.ClientResponseDto;
//import com.edu.Institiute.dto.responseDto.CommonResponseDto;
//import com.edu.Institiute.dto.responseDto.ServiceAreaResponseDto;
//import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseClientDto;
//import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseServiceAreaDto;
//import com.edu.Institiute.entity.Client;
//import com.edu.Institiute.entity.ServiceArea;
//import com.edu.Institiute.entity.ServiceProfessional;
//import com.edu.Institiute.entity.Status;
//import com.edu.Institiute.exception.EntryNotFoundException;
//import com.edu.Institiute.repo.ServiceAreaRepo;
//import com.edu.Institiute.repo.ServiceProfessionalRepo;
//import com.edu.Institiute.repo.StatusRepo;
//import com.edu.Institiute.service.ServiceAreaService;
//import com.edu.Institiute.utill.Generator;
//import com.edu.Institiute.utill.mapper.ServiceAreaMapper;
//import com.edu.Institiute.utill.mapper.ServiceProfessionalMapper;
//import com.edu.Institiute.utill.mapper.StatusMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import software.amazon.ion.Decimal;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class ServiceAreaRegistryImpl implements ServiceAreaService {
//
//    @Autowired
//    private Generator generator;
//
//    @Autowired
//    private ServiceAreaMapper serviceAreaMapper;
//
//    @Autowired
//    private ServiceAreaRepo serviceAreaRepo;
//
//    @Autowired
//    private ServiceProfessionalRepo serviceProfessionalRepo;
//
//    @Autowired
//    private ServiceProfessionalMapper serviceProfessionalMapper;
//
//    @Autowired
//    private StatusMapper statusMapper;
//
//    @Autowired
//    private StatusRepo statusRepo;
//
//    @Override
//    public CommonResponseDto saveServiceArea(RequestRegistryDto dto) {
////
//        try {
//            String serviceAreaId = generator.generateFourNumbers();
//            Optional<ServiceProfessional> serviceProfessional = serviceProfessionalRepo.findByServiceProfessionalId(dto.getProfessionalId());
//            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
//            String loggedUser = SecurityUtil.getLoggedUser();
//            String createdBy = (loggedUser != null) ? loggedUser : dto.getCreatedBy();
//
//            ServiceAreaDto serviceAreaDto = new ServiceAreaDto(
//                    serviceAreaId,
//                    serviceProfessionalMapper.toServiceProfessionalDto(serviceProfessional.get()),
//                    dto.getCity(),
//                    dto.getState(),
//                    dto.getZipCode(),
//                    dto.getMaxDistance(),
//                    dto.getTravelFee(),
//                    createdBy,
//                    new Date(),
//                    "",
//                    null,
//                    statusMapper.toStatusDto(status.get())
//
//            );
//            serviceAreaRepo.save(serviceAreaMapper.dtoToServiceAreaEntity(serviceAreaDto));
//
//            return new CommonResponseDto(201, "Service Area  saved!", serviceAreaDto.getId(), new ArrayList<>());
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
//        }
//    }
//
//
//    @Override
//    public CommonResponseDto updateServiceArea(RequestRegistryDto dto, String serviceAreaId) {
//        try {
//            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
//            Optional<ServiceProfessional> serviceProfessional = serviceProfessionalRepo.findByServiceProfessionalId(dto.getProfessionalId());
//            String loggedUser = SecurityUtil.getLoggedUser();
//            String modifyBy = (loggedUser != null) ? loggedUser : dto.getCreatedBy();
//
//            ServiceArea allServiceAreaForProvidedId = serviceAreaRepo.getAllServiceAreaForProvidedId(serviceAreaId);
//            allServiceAreaForProvidedId.setCity(dto.getCity());
//            allServiceAreaForProvidedId.setState(dto.getState());
//            allServiceAreaForProvidedId.setZipCode(dto.getZipCode());
//            allServiceAreaForProvidedId.setMaxDistance(dto.getMaxDistance());
//            allServiceAreaForProvidedId.setTravelFee(dto.getTravelFee());
//            allServiceAreaForProvidedId.setModifyBy(modifyBy);
//            allServiceAreaForProvidedId.setModifyDate(new Date());
//            allServiceAreaForProvidedId.setStatus(status.get());
//
//            serviceAreaRepo.save(allServiceAreaForProvidedId);
//            return new CommonResponseDto(201, "Service Area Updated!", allServiceAreaForProvidedId.getId(), new ArrayList<>());
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
//        }
//    }
//    @Override
//    public CommonResponseDto removeServiceArea(String serviceAreaId) {
//
//        Optional<ServiceArea> serviceArea = serviceAreaRepo.getAllServiceAreaById(serviceAreaId);
//
//        if (serviceArea.isPresent()) {
//            serviceAreaRepo.delete(serviceArea.get());
//            return new CommonResponseDto(201, "ServiceArea was deleted!", true, new ArrayList<>());
//        } else {
//            throw new EntryNotFoundException("Can't find any client...!");
//        }
//    }
//
//    @Override
//    public PaginatedResponseServiceAreaDto serviceAreaById(String serviceAreaId) throws SQLException {
//        try {
//            List<ServiceArea> allServiceArea = serviceAreaRepo.getAllServiceArea(serviceAreaId);
//            List<ServiceAreaResponseDto> serviceAreaResponseDto = new ArrayList<>();
//
//            for (ServiceArea r : allServiceArea) {
//                serviceAreaResponseDto.add(
//                        new ServiceAreaResponseDto(
//                                r.getId(),
//                                serviceProfessionalMapper.toServiceProfessionalDto(r.getServiceProfessional()),
//                                r.getCity(),
//                                r.getState(),
//                                r.getZipCode(),
//                                r.getMaxDistance(),
//                                r.getTravelFee(),
//                                r.getCreatedBy(),
//                                r.getCreatedDate(),
//                                r.getModifyBy(),
//                                r.getModifyDate(),
//                                statusMapper.toStatusDto(r.getStatus())
//                        )
//                );
//            }
//            return new PaginatedResponseServiceAreaDto(
//                    serviceAreaRepo.serviceAreaCount(serviceAreaId),
//                    serviceAreaResponseDto
//            );
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't find any data for provided ID...!");
//        }
//    }
//
//    @Override
//    public PaginatedResponseServiceAreaDto allServiceAreas() throws SQLException {
//        try {
//            List<ServiceArea> allServiceAreas = serviceAreaRepo.findAll();
//            List<ServiceAreaResponseDto> serviceAreaResponseDto = new ArrayList<>();
//
//            for (ServiceArea r : allServiceAreas) {
//                serviceAreaResponseDto.add(
//                        new ServiceAreaResponseDto(
//                                r.getId(),
//                                serviceProfessionalMapper.toServiceProfessionalDto(r.getServiceProfessional()),
//                                r.getCity(),
//                                r.getState(),
//                                r.getZipCode(),
//                                r.getMaxDistance(),
//                                r.getTravelFee(),
//                                r.getCreatedBy(),
//                                r.getCreatedDate(),
//                                r.getModifyBy(),
//                                r.getModifyDate(),
//                                statusMapper.toStatusDto(r.getStatus())
//
//                        )
//                );
//            }
//            return new PaginatedResponseServiceAreaDto(
//                    serviceAreaRepo.count(),
//                    serviceAreaResponseDto
//            );
//        }catch (Exception e){
//            throw new EntryNotFoundException("Can't find any data...!");
//        }
//    }
//}
