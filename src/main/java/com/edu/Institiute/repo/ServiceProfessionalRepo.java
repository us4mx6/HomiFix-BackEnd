package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.ServiceProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceProfessionalRepo extends JpaRepository<ServiceProfessional,Integer> {

    @Query(value = "SELECT * FROM serviceprofessional WHERE professional_id=:serviceProfessionalId", nativeQuery = true)
    ServiceProfessional getAllServiceProfessionals(@Param("serviceProfessionalId") String serviceProfessionalId);

    @Query(value = "SELECT * FROM serviceprofessional WHERE professional_id=:serviceProfessionalId", nativeQuery = true)
    Optional<ServiceProfessional> getAllServiceProfessionalById(@Param("serviceProfessionalId") String serviceProfessionalId);

    @Query(value = "SELECT * FROM serviceprofessional WHERE professional_id=:serviceProfessionalId", nativeQuery = true)
    List<ServiceProfessional> getAllServiceProfessional(@Param("serviceProfessionalId") String serviceProfessionalId);

    @Query(value = "SELECT COUNT(*) FROM serviceprofessional WHERE professional_id=:serviceProfessionalId", nativeQuery = true)
    Long serviceProfessionalCount(@Param("serviceProfessionalId") String serviceProfessionalId);

}
