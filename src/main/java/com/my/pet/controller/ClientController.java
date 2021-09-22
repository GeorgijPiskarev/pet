package com.my.pet.controller;

import com.my.pet.model.Client;
import com.my.pet.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public Client getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
