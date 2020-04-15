package com.huellapositiva.domain.actions;

import com.huellapositiva.domain.Credential;
import com.huellapositiva.domain.exception.EmailConfirmationHashNotFound;
import com.huellapositiva.domain.repository.CredentialRepository;
import com.huellapositiva.domain.repository.EmailConfirmationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class EmailConfirmationAction {

    private final EmailConfirmationRepository emailConfirmationRepository;

    private final CredentialRepository credentialRepository;

    public void execute(UUID hash) {
//        EmailConfirmation emailConfirmation = emailConfirmationRepository.findByHash(hash.toString())
//                .orElseThrow(() -> new EmailConfirmationHashNotFound("Hash " + hash + " not found"));

        Credential credential = credentialRepository.findByEmailConfirmationHash(hash.toString())
                .orElseThrow(() -> new EmailConfirmationHashNotFound("Hash " + hash + " not found"));

        credential.setEmailConfirmed(true);
        credentialRepository.save(credential);
    }
}
