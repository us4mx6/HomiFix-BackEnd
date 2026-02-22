package com.edu.Institiute.repo;

import com.edu.Institiute.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {

    @Query(value = "SELECT * FROM client WHERE id=:clientId", nativeQuery = true)
    Client getAllClientForProvidedId(@Param("clientId") String clientId);
}
