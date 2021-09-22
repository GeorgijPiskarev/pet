package com.my.pet.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClientDto {
    @NotBlank
    private String name;

    private String company;

    @NotNull
    private Integer yearsOfCooperation;
}
