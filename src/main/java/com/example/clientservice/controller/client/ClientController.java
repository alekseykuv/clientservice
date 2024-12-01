package com.example.clientservice.controller.client;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping()
    public ClientDto addClient(@RequestBody ClientDto clientDto) {
        return clientService.addClient(clientDto);
    }
}
