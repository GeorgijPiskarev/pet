package com.my.pet.controller;

import com.my.pet.model.User;
import com.my.pet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @PostMapping("/create")
    public User register(@RequestBody User user) {
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
