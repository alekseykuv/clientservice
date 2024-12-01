package com.example.clientservice.validator;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.exception.DataClientValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ClientValidatorTest {

    @InjectMocks
    private ClientValidator clientValidator;

    private ClientDto clientDtoNameNull;
    private ClientDto clientDtoNameEmpty;

    @BeforeEach
    public void setUp() {
        clientDtoNameNull = ClientDto.builder().id(1).name(null).build();
        clientDtoNameEmpty = ClientDto.builder().id(1).name("").build();
    }

    @Test
    public void checkNameIsNullTest_nameIsNull() {
        assertThrows(DataClientValidation.class, () -> clientValidator.checkNameIsNull(clientDtoNameNull));
    }

    @Test
    public void checkNameIsNullTest_nameIsEmpty() {
        assertThrows(DataClientValidation.class, () -> clientValidator.checkNameIsNull(clientDtoNameEmpty));
    }
}
