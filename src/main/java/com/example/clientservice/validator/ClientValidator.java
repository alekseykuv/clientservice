package com.example.clientservice.validator;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.exception.DataClientValidation;
import org.springframework.stereotype.Component;

@Component
public class ClientValidator {

    public void checkNameIsNull(ClientDto clientDto) {
        if (clientDto.getName() == null || clientDto.getName().isEmpty()) {
            throw new DataClientValidation("The name field must not be null or empty");
        }
    }
}
