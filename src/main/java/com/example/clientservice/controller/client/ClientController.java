package com.example.clientservice.controller.client;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.dto.client.EmailDto;
import com.example.clientservice.dto.client.PhoneDto;
import com.example.clientservice.service.client.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Добавление клиента", description = "Добавляет нового клиента в бд")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Клиент успешно добавлен"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса")
    })
    @PostMapping()
    public ClientDto addClient(@RequestBody ClientDto clientDto) {
        return clientService.addClient(clientDto);
    }

    @Operation(summary = "Добавление телефона клиента", description = "Добавляет новый телефон для указанного клиента")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Телефон успешно добавлен"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса")
    })
    @PostMapping("/{id}/contacts/phones")
    public void addPhone(@PathVariable("id") long id, @Valid @RequestBody PhoneDto phoneDto) {
        clientService.addPhone(id, phoneDto);
    }

    @Operation(summary = "Добавление email'а клиента", description = "Добавляет новый email для указанного клиента")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email успешно добавлен"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса")
    })
    @PostMapping("/{id}/contacts/emails")
    public void addEmail(@PathVariable("id") long id, @Valid @RequestBody EmailDto emailDto) {
        clientService.addEmail(id, emailDto);
    }

    @Operation(summary = "Получение списка всех клиентов", description = "Возвращает список всех клиентов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список клиентов успешно получен"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса")
    })
    @GetMapping()
    public List<ClientDto> getClients() {
        return clientService.getClients();
    }

    @Operation(summary = "Получение клиента по ID", description = "Возвращает информацию клиента по его ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Клиент найден"),
            @ApiResponse(responseCode = "400", description = "Клиент не найден")
    })
    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable("id") long id) {
        return clientService.getClient(id);
    }

    @Operation(summary = "Получение всех контактов клиента", description = "Возвращает список всех контактов клиента по его ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Контакты успешно получены"),
            @ApiResponse(responseCode = "400", description = "Клиент не найден")
    })
    @GetMapping("/{id}/contacts")
    public List<String> getContactsClient(@PathVariable("id") long id) {
        return clientService.getContactsClient(id);
    }

    @Operation(summary = "Получение всех телефонов клиента", description = "Возвращает список всех телефонов клиента по его ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Телефоны успешно получены"),
            @ApiResponse(responseCode = "400", description = "Клиент не найден")
    })
    @GetMapping("/{id}/contacts/phones")
    public List<String> getPhoneContacts(@PathVariable("id") long id) {
        return clientService.getPhoneContacts(id);
    }

    @Operation(summary = "Получение всех email'ов клиента", description = "Возвращает список всех email'ов клиента по его ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email успешно получены"),
            @ApiResponse(responseCode = "400", description = "Клиент не найден")
    })
    @GetMapping("/{id}/contacts/emails")
    public List<String> getEmailContacts(@PathVariable("id") long id) {
        return clientService.getEmailContacts(id);
    }
}
