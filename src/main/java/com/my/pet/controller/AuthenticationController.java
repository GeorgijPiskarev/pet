package com.my.pet.controller;

import com.my.pet.model.dto.Credentials;
import com.my.pet.model.dto.UserDto;
import com.my.pet.security.AuthenticationDTO;
import com.my.pet.security.JwtTokenProvider;
import com.my.pet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public Credentials authenticate(@RequestBody AuthenticationDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDto user = userService.findByEmail(request.getEmail());
        String token = jwtTokenProvider.createToken(request.getEmail(), user.getRole().name());
        Credentials response = new Credentials();
        response.setEmail(request.getEmail());
        response.setToken(token);

        return response;
    }
}
