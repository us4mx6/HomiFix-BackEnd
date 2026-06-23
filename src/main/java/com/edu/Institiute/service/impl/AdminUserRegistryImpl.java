package com.edu.Institiute.service.impl;

import com.edu.Institiute.config.SecurityUtil;
import com.edu.Institiute.dto.AdminUserDto;
import com.edu.Institiute.dto.requestDto.RequestRegistryDto;
import com.edu.Institiute.dto.responseDto.AdminUserResponseDto;
import com.edu.Institiute.dto.responseDto.CommonResponseDto;
import com.edu.Institiute.dto.responseDto.paginated.PaginatedResponseAdminUserDto;
import com.edu.Institiute.entity.AdminUser;
import com.edu.Institiute.entity.Status;
import com.edu.Institiute.exception.EntryNotFoundException;
import com.edu.Institiute.repo.AdminUserRepo;
import com.edu.Institiute.repo.StatusRepo;
import com.edu.Institiute.service.AdminUserService;
import com.edu.Institiute.utill.Generator;
import com.edu.Institiute.utill.mapper.AdminUserMapper;
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
public class AdminUserRegistryImpl implements AdminUserService {

    @Autowired
    private Generator generator;

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserRepo adminUserRepo;

    @Autowired
    private StatusMapper statusMapper;

    @Autowired
    private StatusRepo statusRepo;

    @Override
    public CommonResponseDto saveAdminUser(RequestRegistryDto dto) {
        try {
            String adminCode = generator.generateFourNumbers();
            Optional<Status> status = statusRepo.findStatusById(dto.getStatus());
            String loggedUser = SecurityUtil.getLoggedUser();
            String createdBy = (loggedUser != null) ? loggedUser : dto.getCreatedBy();

            AdminUserDto adminUserDto = new AdminUserDto(
                    adminCode,
                    dto.getRole(),
                    dto.getPermissions(),
                    createdBy,
                    new Date(),
                    "",
                    null,
                    statusMapper.toStatusDto(status.get())
            );
            adminUserRepo.save(adminUserMapper.dtoToAdminUserEntity(adminUserDto));

            return new CommonResponseDto(201, "Admin User saved!", adminUserDto.getAdminId(), new ArrayList<>());
        } catch (Exception e) {
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto updateAdminUser(RequestRegistryDto dto, String adminId) {
        try {
            String loggedUser = SecurityUtil.getLoggedUser();
            String modifyBy = (loggedUser != null) ? loggedUser : dto.getCreatedBy();

            AdminUser adminUser = adminUserRepo.getAdminUserForProvidedId(adminId);
            adminUser.setRole(dto.getRole());
            adminUser.setPermissions(dto.getPermissions());
            adminUser.setModifyBy(modifyBy);
            adminUser.setModifyDate(new Date());

            adminUserRepo.save(adminUser);
            return new CommonResponseDto(201, "Admin User Updated!", adminUser.getAdminId(), new ArrayList<>());
        } catch (Exception e) {
            throw new EntryNotFoundException("Can't Save because of this Error -->  " + e);
        }
    }

    @Override
    public CommonResponseDto removeAdminUser(String adminId) {
        Optional<AdminUser> adminUsers = adminUserRepo.getAdminUserById(adminId);

        if (adminUsers.isPresent()) {
            adminUserRepo.delete(adminUsers.get());
            return new CommonResponseDto(201, "Admin User was deleted!", true, new ArrayList<>());
        } else {
            throw new EntryNotFoundException("Can't find any admin user...!");
        }
    }

    @Override
    public PaginatedResponseAdminUserDto adminUserById(String adminId) throws SQLException {
        try {
            List<AdminUser> allAdminUsers = adminUserRepo.getAllAdminUser(adminId);
            List<AdminUserResponseDto> adminUserResponseDto = new ArrayList<>();

            for (AdminUser r : allAdminUsers) {
                adminUserResponseDto.add(
                        new AdminUserResponseDto(
                                r.getAdminId(),
                                r.getRole(),
                                r.getPermissions(),
                                r.getCreatedBy(),
                                r.getCreatedDate(),
                                r.getModifyBy(),
                                r.getModifyDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }
            return new PaginatedResponseAdminUserDto(
                    adminUserRepo.adminUserCount(adminId),
                    adminUserResponseDto
            );
        } catch (Exception e) {
            throw new EntryNotFoundException("Can't find any data for provided ID...!");
        }
    }

    @Override
    public PaginatedResponseAdminUserDto allAdminUsers() throws SQLException {
        try {
            List<AdminUser> allAdminUsers = adminUserRepo.findAll();
            List<AdminUserResponseDto> adminUserResponseDto = new ArrayList<>();

            for (AdminUser r : allAdminUsers) {
                adminUserResponseDto.add(
                        new AdminUserResponseDto(
                                r.getAdminId(),
                                r.getRole(),
                                r.getPermissions(),
                                r.getCreatedBy(),
                                r.getCreatedDate(),
                                r.getModifyBy(),
                                r.getModifyDate(),
                                statusMapper.toStatusDto(r.getStatus())
                        )
                );
            }
            return new PaginatedResponseAdminUserDto(
                    adminUserRepo.count(),
                    adminUserResponseDto
            );
        } catch (Exception e) {
            throw new EntryNotFoundException("Can't find any data...!");
        }
    }
}
