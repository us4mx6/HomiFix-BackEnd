package com.edu.Institiute.dto.responseDto.paginated;

import com.edu.Institiute.dto.responseDto.ServiceProfessionalResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseServiceProfessionalDto {
    private Long count;
    private List<ServiceProfessionalResponseDto> dataList;
}
