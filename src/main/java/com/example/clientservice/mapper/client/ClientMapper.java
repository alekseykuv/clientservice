package com.example.clientservice.mapper.client;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.dto.client.EmailDto;
import com.example.clientservice.dto.client.PhoneDto;
import com.example.clientservice.model.client.Client;
import com.example.clientservice.model.client.Email;
import com.example.clientservice.model.client.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    ClientDto toDto(Client client);

    Client toEntity(ClientDto clientDto);

    PhoneDto toDto(Phone phone);

    Phone toEntity(PhoneDto phoneDto);

    EmailDto toDto(Email email);

    Email toEntity(EmailDto emailDto);

    List<ClientDto> toClientsDto(List<Client> clients);

    List<Client> toClients(List<ClientDto> clientsDto);


}
