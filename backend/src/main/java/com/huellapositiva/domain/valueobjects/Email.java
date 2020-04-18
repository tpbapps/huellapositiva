package com.huellapositiva.domain.valueobjects;

import com.huellapositiva.domain.exception.EmailNotAllowed;
import lombok.EqualsAndHashCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EqualsAndHashCode
public class Email {
    private String email;

    private Email(String email) {
        this.email = email;
    }

    public static Email from(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean emailNotAllowed = !matcher.find();
        if(emailNotAllowed){
            throw new EmailNotAllowed("Invalid email: " + email);
        }
        return new Email(email);
    }

    @Override
    public String toString() {
        return email;
    }
}


