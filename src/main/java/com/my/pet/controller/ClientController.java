package com.my.pet.controller;

import com.my.pet.model.dto.ClientDto;
import com.my.pet.model.dto.ClientListDto;
import com.my.pet.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public ClientListDto getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public ClientDto getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public ClientDto create(@RequestBody ClientDto clientDto) {
        return clientService.create(clientDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
