package com.edu.Institiute.repo;

import com.edu.Institiute.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM user WHERE user_name=:username", nativeQuery = true)
    User findByUserName(@Param("username") String username);
}
