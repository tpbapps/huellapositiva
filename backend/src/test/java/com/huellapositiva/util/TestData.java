package com.huellapositiva.util;

import com.huellapositiva.infrastructure.orm.JpaCredentialRepository;
import com.huellapositiva.infrastructure.orm.JpaVolunteerRepository;
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
    private EmailConfirmationRepository emailConfirmationRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void resetData() {
        volunteerRepository.deleteAll();
        jpaCredentialRepository.deleteAll();
        credentialRepository.deleteAll();
        emailConfirmationRepository.deleteAll();
    }

    public EmailConfirmation createEmailConfirmation(UUID token){
        EmailConfirmation emailConfirmation = EmailConfirmation.builder()
                .email("foo@huellapositiva.com")
                .hash(token.toString())
                .build();

        return emailConfirmationRepository.save(emailConfirmation);
    }

    public void createCredential( String email, UUID token){
        EmailConfirmation emailConfirmation = createEmailConfirmation(token);
        Role role = roleRepository.findByName(Roles.VOLUNTEER.toString()).get();

        Credential credential = Credential.builder()
                .email(email)
                .hashedPassword("xxx")
                .emailConfirmed(false)
                .emailConfirmation(emailConfirmation)
                .roles(Collections.singleton(role))
                .build();

        credentialRepository.save(credential);
    }
}
