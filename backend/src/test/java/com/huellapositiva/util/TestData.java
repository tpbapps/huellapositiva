package com.huellapositiva.util;

import com.huellapositiva.infrastructure.orm.model.Credential;
import com.huellapositiva.infrastructure.orm.model.EmailConfirmation;
import com.huellapositiva.infrastructure.orm.model.Role;
import com.huellapositiva.domain.Roles;
import com.huellapositiva.infrastructure.orm.repository.JpaEmailConfirmationRepository;
import com.huellapositiva.infrastructure.orm.repository.JpaCredentialRepository;
import com.huellapositiva.infrastructure.orm.repository.JpaRoleRepository;
import com.huellapositiva.infrastructure.orm.repository.JpaVolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

@TestComponent
@Transactional
public class TestData {

    @Autowired
    private JpaVolunteerRepository volunteerRepository;

    @Autowired
    private JpaCredentialRepository jpaCredentialRepository;

    @Autowired
    private JpaEmailConfirmationRepository jpaEmailConfirmationRepository;

    @Autowired
    private JpaRoleRepository roleRepository;

    public void resetData() {
        volunteerRepository.deleteAll();
        jpaCredentialRepository.deleteAll();
        jpaCredentialRepository.deleteAll();
        jpaEmailConfirmationRepository.deleteAll();
    }

    public EmailConfirmation createEmailConfirmation(UUID token){
        EmailConfirmation emailConfirmation = EmailConfirmation.builder()
                .email("foo@huellapositiva.com")
                .hash(token.toString())
                .build();

        return jpaEmailConfirmationRepository.save(emailConfirmation);
    }

    public Credential createCredential( String email, UUID token){
        EmailConfirmation emailConfirmation = createEmailConfirmation(token);
        Role role = roleRepository.findByName(Roles.VOLUNTEER.toString()).get();

        Credential credential = Credential.builder()
                .email(email)
                .hashedPassword("xxx")
                .emailConfirmed(false)
                .emailConfirmation(emailConfirmation)
                .roles(Collections.singleton(role))
                .build();

        return jpaCredentialRepository.save(credential);
    }
}
