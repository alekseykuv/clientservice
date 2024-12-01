package com.example.clientservice.validator;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.dto.client.PhoneDto;
import com.example.clientservice.exception.DataClientValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientValidator {

    public void checkNameIsNull(ClientDto clientDto) {
        if (clientDto.getName() == null || clientDto.getName().isEmpty()) {
            log.error("The name field must not be null or empty");
            throw new DataClientValidation("The name field must not be null or empty");
        }
    }

    public void checkPhoneIsNull(PhoneDto phoneDto) {
        if (phoneDto.getNumber() == null || phoneDto.getNumber().isEmpty()) {
            log.error("The number field must not be null or empty");
            throw new DataClientValidation("The number field must not be null or empty");
        }
    }
}
