package com.my.pet.service;

import com.my.pet.exception.NotFoundException;
import com.my.pet.model.Client;
import com.my.pet.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("client with id=" + id + "was not found"));
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
