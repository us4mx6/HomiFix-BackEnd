package com.edu.Institiute.repo;

import com.edu.Institiute.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminUserRepo extends JpaRepository<AdminUser, String> {

    @Query(value = "SELECT * FROM adminuser WHERE admin_id=:adminId", nativeQuery = true)
    AdminUser getAdminUserForProvidedId(@Param("adminId") String adminId);


    @Query(value = "SELECT * FROM adminuser WHERE admin_id=:adminId", nativeQuery = true)
    Optional<AdminUser> getAdminUserById(@Param("adminId") String adminId);

    @Query(value = "SELECT * FROM adminuser WHERE admin_id=:adminId", nativeQuery = true)
    List<AdminUser> getAllAdminUser(@Param("adminId") String adminId);

    @Query(value = "SELECT COUNT(*) FROM adminuser WHERE admin_id=:adminId", nativeQuery = true)
    Long adminUserCount(@Param("adminId") String adminId);
}