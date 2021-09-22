package com.my.pet.model;

import com.my.pet.model.enums.Role;
import com.my.pet.model.enums.Status;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
