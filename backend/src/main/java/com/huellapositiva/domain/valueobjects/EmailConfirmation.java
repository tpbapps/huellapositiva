package com.huellapositiva.domain.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@EqualsAndHashCode
@ToString
public class EmailConfirmation {
    private final Email email;
    private final String token;

    private EmailConfirmation(Email email, String token) {
        this.email = email;
        this.token = token;
    }

    public static EmailConfirmation from(String email) {
        return new EmailConfirmation(
                Email.from(email), UUID.randomUUID().toString());
    }

    public String getEmail(){
        return email.toString();
    }

    public String getToken() {
        return token;
    }
}
