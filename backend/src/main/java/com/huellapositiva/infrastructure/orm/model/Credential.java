package com.huellapositiva.infrastructure.orm.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "credentials")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "hashed_password", nullable = false)
    private String hashedPassword;

    @Column(name = "email_confirmed", nullable = false)
    private Boolean emailConfirmed;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "credential_roles",
            joinColumns = {@JoinColumn(name = "credential_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "email_confirmation_id")
    private EmailConfirmation emailConfirmation;
}
