package com.my.pet.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "clients")
@Accessors(chain = true)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @NotNull
    @Column(name = "years_of_cooperation")
    private Integer yearsOfCooperation;
}
