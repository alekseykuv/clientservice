package com.example.clientservice.dto.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private long id;
    private String name;
}
