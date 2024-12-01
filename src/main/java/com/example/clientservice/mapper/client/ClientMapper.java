package com.example.clientservice.mapper.client;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.dto.client.PhoneDto;
import com.example.clientservice.model.client.Client;
import com.example.clientservice.model.client.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    ClientDto toDto(Client client);

    Client toEntity(ClientDto clientDto);

    PhoneDto toDto(Phone phone);

    Phone toEntity(PhoneDto phoneDto);


}
