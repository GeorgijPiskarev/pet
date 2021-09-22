package com.my.pet.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Permission {
    USER_READ("user:read"),
    USER_WRITE("user:write");
    private final String permission;
}
