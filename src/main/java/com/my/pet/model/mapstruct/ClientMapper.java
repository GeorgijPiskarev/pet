package com.my.pet.model.mapstruct;

import com.my.pet.model.entity.Client;
import com.my.pet.model.dto.ClientDto;
import com.my.pet.model.mapstruct.config.IgnoreUnmappedMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreUnmappedMapperConfig.class)
public interface ClientMapper {
    Client toClient(ClientDto dto);

    ClientDto toClientDto(Client client);
}
