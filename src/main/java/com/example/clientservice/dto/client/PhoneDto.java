package com.example.clientservice.dto.client;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneDto {

    private long id;

    @Pattern(regexp = "^[0-9]+$", message = "Phone number can only contain numbers")
    private String number;
}
