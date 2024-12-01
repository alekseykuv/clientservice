package com.example.clientservice.dto.client;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailDto {
    private long id;

    @Email(message = "Invalid email format")
    private String email;
}
