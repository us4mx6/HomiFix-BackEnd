//package com.edu.Institiute.repo;
//
//import com.edu.Institiute.entity.Client;
//import com.edu.Institiute.entity.ServiceProfessional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface ServiceProfessionalRepo extends JpaRepository<ServiceProfessional,Long> {
//
//    @Query(value = "SELECT * FROM serviceprofessional WHERE professional_id=:professionalId", nativeQuery = true)
//    ServiceProfessional getServiceProfessionalByProvidedId(@Param("professionalId") Long professionalId);
//
//    @Query(value = "SELECT * FROM serviceprofessional WHERE professional_id=:professionalId", nativeQuery = true)
//    Optional<ServiceProfessional> findByServiceProfessionalId(@Param("professionalId") Long professionalId);
//
//    @Query(value = "SELECT * FROM serviceprofessional WHERE professional_id=:professionalId", nativeQuery = true)
//    List<ServiceProfessional> getAllServiceProfessionalById(@Param("professionalId") Long professionalId);
//
//    @Query(value = "SELECT * FROM serviceprofessional WHERE professional_id=:professionalId", nativeQuery = true)
//    List<ServiceProfessional> getAllServiceProfessional();
//
//
//    @Query(value = "SELECT COUNT(*) FROM serviceprofessional WHERE professional_id=:professionalId", nativeQuery = true)
//    Long serviceProfessionalCount(@Param("professionalId") Long professionalId);
//
//}
