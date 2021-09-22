package com.my.pet.controller;

import com.my.pet.model.User;
import com.my.pet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
