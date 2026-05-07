package com.edu.Institiute.repo;

import com.edu.Institiute.entity.ServiceArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceAreaRepo extends JpaRepository<ServiceArea,String> {

    @Query(value = "SELECT * FROM servicearea WHERE id = :serviceAreaId", nativeQuery = true)
    ServiceArea getAllServiceAreaForProvidedId(
            @Param("serviceAreaId") String serviceAreaId
    );

    @Query(value = "SELECT * FROM servicearea WHERE id = :serviceAreaId", nativeQuery = true)
    Optional<ServiceArea> getAllServiceAreaById(
            @Param("serviceAreaId") String serviceAreaId
    );

    @Query(value = "SELECT * FROM servicearea WHERE id = :serviceAreaId", nativeQuery = true)
    List<ServiceArea> getAllServiceArea(
            @Param("serviceAreaId") String serviceAreaId
    );

    @Query(value = "SELECT COUNT(*) FROM servicearea WHERE id = :serviceAreaId", nativeQuery = true)
    Long serviceAreaCount(
            @Param("serviceAreaId") String serviceAreaId
    );
}