package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.AdminUserDto;
import com.edu.Institiute.entity.AdminUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface AdminUserMapper {
    AdminUser dtoToAdminUserEntity(AdminUserDto adminUserDto);
    AdminUserDto toAdminUserDto(AdminUser adminUser);
}
