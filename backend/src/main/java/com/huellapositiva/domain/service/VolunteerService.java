package com.huellapositiva.domain.service;

import com.huellapositiva.application.dto.RegisterVolunteerRequestDto;
import com.huellapositiva.domain.*;
import com.huellapositiva.domain.exception.RoleNotFound;
import com.huellapositiva.domain.repository.EmailConfirmationRepository;
import com.huellapositiva.domain.repository.RoleRepository;
import com.huellapositiva.domain.repository.VolunteerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class VolunteerService {

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final VolunteerRepository volunteerRepository;

    @Autowired
    private final EmailConfirmationRepository emailConfirmationRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public Integer registerVolunteer(RegisterVolunteerRequestDto dto) {
        Role role = roleRepository.findByName(Roles.VOLUNTEER.toString())
                .orElseThrow(() -> new RoleNotFound("Role VOLUNTEER not found."));
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        EmailConfirmation emailConfirmation = EmailConfirmation.builder()
                .email(dto.getEmail())
                .hash(UUID.randomUUID().toString())
                .build();
        emailConfirmation = emailConfirmationRepository.save(emailConfirmation);
        Credential credential = Credential.builder()
                .email(dto.getEmail())
                .hashedPassword(hashedPassword)
                .roles(Collections.singleton(role))
                .emailConfirmed(false)
                .emailConfirmation(emailConfirmation)
                .build();
        Volunteer volunteer = Volunteer.builder()
                .credential(credential)
                .build();
        volunteer = volunteerRepository.save(volunteer);
        return volunteer.getId();
    }
}
