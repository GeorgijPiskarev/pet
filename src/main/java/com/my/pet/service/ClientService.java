package com.my.pet.service;

import com.my.pet.exception.NotFoundException;
import com.my.pet.model.entity.Client;
import com.my.pet.model.dto.ClientDto;
import com.my.pet.model.dto.ClientListDto;
import com.my.pet.model.mapstruct.ClientMapper;
import com.my.pet.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientListDto getAll() {
        List<ClientDto> clients = clientRepository.findAll().stream()
                .map(clientMapper::toClientDto)
                .collect(Collectors.toList());

        return new ClientListDto().setClients(clients);
    }

    public ClientDto getById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("client with id=" + id + "was not found"));

        return clientMapper.toClientDto(client);
    }

    public ClientDto create(ClientDto client) {
        return clientMapper.toClientDto(clientRepository.save(clientMapper.toClient(client)));
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
