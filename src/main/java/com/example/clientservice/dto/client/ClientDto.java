package com.example.clientservice.dto.client;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private long id;
    private String name;
    private List<EmailDto> emails;
    private List<PhoneDto> phones;
}
