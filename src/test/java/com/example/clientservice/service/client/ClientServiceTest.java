package com.example.clientservice.service.client;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.exception.DataClientValidation;
import com.example.clientservice.mapper.client.ClientMapper;
import com.example.clientservice.model.client.Client;
import com.example.clientservice.repository.client.ClientRepository;
import com.example.clientservice.validator.ClientValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @Mock
    private ClientValidator clientValidator;

    private ClientDto clientDtoNameNull;
    private ClientDto clientDtoBob;

    private Client clientBob;

    @BeforeEach
    public void setUp() {
        clientDtoNameNull = ClientDto.builder().name(null).build();
        clientDtoBob = ClientDto.builder().id(1).name("Bob").build();
        clientBob = Client.builder().id(1).name("Bob").build();

    }

    @Test
    public void testAddClient_nameIsNull() {
        doThrow(new DataClientValidation("The name field must not be null or empty"))
                .when(clientValidator).checkNameIsNull(clientDtoNameNull);
        assertThrows(DataClientValidation.class, () -> clientService.addClient(clientDtoNameNull));
        verify(clientValidator, times(1)).checkNameIsNull(clientDtoNameNull);

    }

    @Test
    public void testAddClient_save() {
        when(clientMapper.toEntity(clientDtoBob)).thenReturn(clientBob);

        clientService.addClient(clientDtoBob);
        verify(clientRepository, times(1)).save(clientBob);
    }
}
