package com.example.clientservice.controller.client;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.dto.client.EmailDto;
import com.example.clientservice.dto.client.PhoneDto;
import com.example.clientservice.service.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/{id}/contacts/phone")
    public void addPhone(@PathVariable int id, @Valid @RequestBody PhoneDto phoneDto) {
        clientService.addPhone(id, phoneDto);
    }

    @PostMapping("/{id}/contacts/email")
    public void addEmail(@PathVariable int id, @Valid @RequestBody EmailDto emailDto) {
        clientService.addEmail(id, emailDto);
    }
}
