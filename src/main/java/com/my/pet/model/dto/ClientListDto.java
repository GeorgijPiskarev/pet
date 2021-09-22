package com.my.pet.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ClientListDto {
    private List<ClientDto> clients;
}
