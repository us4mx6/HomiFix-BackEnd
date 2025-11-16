package com.edu.Institiute.service.impl;

import com.edu.Institiute.dto.ClientDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
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

            ClientDto clientDto = new ClientDto(
                    clientCode,
                    dto.getHomeAddress(),
                    dto.getPreferredContactMethod(),
                    dto.getEmergencyContactName(),
                    dto.getEmergencyContactPhone(),
                    dto.getCreatedBy(),
                    new Date(),
                    "",
                    new Date(),
                    statusMapper.toStatusDto(status.get())

            );
            clientRepo.save(clientMapper.dtoToClientEntity(clientDto));

            return new CommonResponseDto(201, "Client  saved!", clientDto.getClientId(), new ArrayList<>());
        }catch (Exception e){
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }
}
