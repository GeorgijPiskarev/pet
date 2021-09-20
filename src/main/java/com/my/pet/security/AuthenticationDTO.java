package com.my.pet.security;

import lombok.Data;

@Data
public class AuthenticationDTO {
    private String email;
    private String password;
}
