package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Client;
import com.edu.Institiute.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {

    @Query(value = "SELECT * FROM client WHERE id=:clientId", nativeQuery = true)
    Client getAllClientForProvidedId(@Param("clientId") String clientId);

    @Query(value = "SELECT * FROM client WHERE id=:clientId", nativeQuery = true)
    Optional<Client> getAllClientById(@Param("clientId") String clientId);

    @Query(value = "SELECT * FROM client WHERE id=:clientId", nativeQuery = true)
    List<Client> getAllClient(@Param("clientId") String clientId);

    @Query(value = "SELECT COUNT(*) FROM client WHERE id=:clientId", nativeQuery = true)
    Long clientCount(@Param("clientId") String clientId);
}
