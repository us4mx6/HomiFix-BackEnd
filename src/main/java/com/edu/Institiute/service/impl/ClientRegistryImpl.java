package com.edu.Institiute.service.impl;

import com.edu.Institiute.config.SecurityUtil;
import com.edu.Institiute.dto.ClientDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.Course;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.ClientRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.service.ClientService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.ClientMapper;
import com.edu.Institiute.utill.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class ClientRegistryImpl implements ClientService {

    @Autowired
    private Generator generator;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Override
    public CommonResponseDto saveClient(RequestRegistryDto dto) {
//
        try {
            String clientCode = generator.generateFourNumbers();
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
            String loggedUser = SecurityUtil.getLoggedUser();
            String createdBy = (loggedUser != null) ? loggedUser : dto.getCreatedBy();

            ClientDto clientDto = new ClientDto(
                    clientCode,
                    dto.getHomeAddress(),
                    dto.getPreferredContactMethod(),
                    dto.getEmergencyContactName(),
                    dto.getEmergencyContactPhone(),
                    createdBy,
                    new Date(),
                    "",
                    null,
                    statusMapper.toStatusDto(status.get())

            );
            clientRepo.save(clientMapper.dtoToClientEntity(clientDto));

            return new CommonResponseDto(201, "Client  saved!", clientDto.getId(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateClient(RequestRegistryDto dto, String clientId) {
        try {
            String loggedUser = SecurityUtil.getLoggedUser();
            String modifyBy = (loggedUser != null) ? loggedUser : dto.getCreatedBy();

            Client allClientForProvidedId = clientRepo.getAllClientForProvidedId(clientId);
            allClientForProvidedId.setHomeAddress(dto.getHomeAddress());
            allClientForProvidedId.setPreferredContactMethod(dto.getPreferredContactMethod());
            allClientForProvidedId.setEmergencyContactName(dto.getEmergencyContactName());
            allClientForProvidedId.setEmergencyContactPhone(dto.getEmergencyContactPhone());
            allClientForProvidedId.setModifyBy(modifyBy);
            allClientForProvidedId.setModifyDate(new Date());


            clientRepo.save(allClientForProvidedId);
            return new CommonResponseDto(201, "Client Updated!", allClientForProvidedId.getId(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }
}
