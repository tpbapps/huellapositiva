package com.huellapositiva.domain.repository;

import com.huellapositiva.domain.*;
import com.huellapositiva.domain.exception.RoleNotFound;
import com.huellapositiva.infrastructure.orm.JpaRoleRepository;
import com.huellapositiva.infrastructure.orm.JpaVolunteerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

@Component
@Transactional
@AllArgsConstructor
public class VolunteerRepository {

    @Autowired
    private final JpaVolunteerRepository volunteerRepository;

    @Autowired
    private final JpaEmailConfirmationRepository jpaEmailConfirmationRepository;

    @Autowired
    private final JpaRoleRepository jpaRoleRepository;

    public Integer save(ExpressRegistrationVolunteer expressVolunteer) {
        Role role = jpaRoleRepository.findByName(Roles.VOLUNTEER.toString())
                .orElseThrow(() -> new RoleNotFound("Role VOLUNTEER not found."));
        EmailConfirmation emailConfirmation = EmailConfirmation.builder()
                .email(expressVolunteer.getEmail())
                .hash(UUID.randomUUID().toString())
                .build();
        emailConfirmation = jpaEmailConfirmationRepository.save(emailConfirmation);
        Credential credential = Credential.builder()
                .email(expressVolunteer.getEmail())
                .hashedPassword(expressVolunteer.getHashedPassword())
                .roles(Collections.singleton(role))
                .emailConfirmed(false)
                .emailConfirmation(emailConfirmation)
                .build();
        Volunteer volunteer = Volunteer.builder()
                .credential(credential)
                .build();
        return volunteerRepository.save(volunteer).getId();
    }
}
