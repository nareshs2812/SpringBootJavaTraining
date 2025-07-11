package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {
    Optional<RegisterDetails> findByUserName(String userName);

    @Query("SELECT u FROM RegisterDetails u JOIN u.roles r WHERE r.name = :roleName")
    List<RegisterDetails> findByRoleName(@Param("roleName") String roleName);
}
