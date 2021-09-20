package com.my.pet.controller;

import com.my.pet.exception.NotFoundException;
import com.my.pet.model.Client;
import com.my.pet.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {
    private final ClientRepository clientRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public Client getById(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("client with id=" + id + "was not found"));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public Client create(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteById(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
