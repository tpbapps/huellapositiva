package com.huellapositiva.domain.repository;

import com.huellapositiva.domain.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {

    @Query("FROM Credential c WHERE c.email = :email")
    Optional<Credential> findByEmail(@Param("email") String email);
}
