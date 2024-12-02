package com.example.clientservice.service.client;

import com.example.clientservice.dto.client.ClientDto;
import com.example.clientservice.dto.client.EmailDto;
import com.example.clientservice.dto.client.PhoneDto;
import com.example.clientservice.mapper.client.ClientMapper;
import com.example.clientservice.model.client.Client;
import com.example.clientservice.model.client.Email;
import com.example.clientservice.model.client.Phone;
import com.example.clientservice.repository.client.ClientRepository;
import com.example.clientservice.repository.client.EmailRepository;
import com.example.clientservice.repository.client.PhoneRepository;
import com.example.clientservice.validator.ClientValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final PhoneRepository phoneRepository;
    private final EmailRepository emailRepository;
    private final ClientMapper clientMapper;
    private final ClientValidator clientValidator;

    @Transactional
    public ClientDto addClient(ClientDto clientDto) {
        clientValidator.checkNameIsNull(clientDto);

        Client client = clientMapper.toEntity(clientDto);
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Transactional
    public void addPhone(long id, PhoneDto phoneDto) {
        clientValidator.checkPhoneIsNull(phoneDto);
        checkExistsClientInBd(id);

        Phone phone = clientMapper.toEntity(phoneDto);

        phoneRepository.addPhoneByClientId(id, phone.getNumber());

    }

    @Transactional
    public void addEmail(long id, EmailDto emailDto) {
        clientValidator.checkEmailIsNull(emailDto);
        checkExistsClientInBd(id);

        Email email = clientMapper.toEntity(emailDto);

        emailRepository.addEmailByClientId(id, email.getEmail());
    }

    @Transactional(readOnly = true)
    public List<ClientDto> getClients() {
        return clientMapper.toClientsDto(clientRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ClientDto getClient(long id) {
        return clientRepository.findById(id).map(clientMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " not found"));
    }

    @Transactional(readOnly = true)
    public List<String> getContactsClient(long id) {
        checkExistsClientInBd(id);

        List<String> contacts = new ArrayList<>();
        contacts.addAll(emailRepository.findEmailsByClientId(id));
        contacts.addAll(phoneRepository.findPhonesByClientId(id));

        return contacts;
    }

    @Transactional(readOnly = true)
    public List<String> getPhoneContacts(long id) {
        checkExistsClientInBd(id);

        return phoneRepository.findPhonesByClientId(id);
    }

    @Transactional(readOnly = true)
    public List<String> getEmailContacts(long id) {
        checkExistsClientInBd(id);

        return emailRepository.findEmailsByClientId(id);
    }

    private void checkExistsClientInBd(long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client with id " + id + " not found");
        }
    }
}
