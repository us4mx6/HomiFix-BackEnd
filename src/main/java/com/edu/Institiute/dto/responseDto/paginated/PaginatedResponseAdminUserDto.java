package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.AdminUserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseAdminUserDto {
    private Long count;
    private List<AdminUserResponseDto> dataList;
}
