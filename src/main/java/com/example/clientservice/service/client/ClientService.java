package com.example.clientservice.service.client;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.mapper.client.ClientMapper;
import com.example.clientservice.model.client.Client;
import com.example.clientservice.repository.client.ClientRepository;
import com.example.clientservice.validator.ClientValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientValidator clientValidator;

    public ClientDto addClient(ClientDto clientDto) {
        clientValidator.checkNameIsNull(clientDto);

        Client client = clientMapper.toEntity(clientDto);
        return clientMapper.toDto(clientRepository.save(client));
    }
}
