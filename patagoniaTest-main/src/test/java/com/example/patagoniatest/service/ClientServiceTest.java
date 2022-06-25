package com.example.patagoniatest.service;

import com.example.patagoniatest.entity.Client;
import com.example.patagoniatest.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientServiceTest {

    @Mock
    ClientRepository clientRepository; //repositorio simulado

    @InjectMocks
    ClientService clientService; //y se van a insertar en el service

    Client client;

    @BeforeEach
    void setUp() {
        client = new Client(1L, "Menta Alegre", 3000);
    }

    @Test
    void getClients() {
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client(1L, "Menta Alegre", 3000));
        clientList.add(new Client(2L, "Potus Alegre", 3000));
        when(clientRepository.findAll()).thenReturn(clientList);
        assertFalse(clientList.isEmpty());

    }

    @Test
    void addClient() {
        Client newClient = new Client(null, "Rosa Mosqueta", 3000);
        Client addClient = new Client(4L, "Rosa Mosqueta", 3000);
        when(clientRepository.save(newClient)).thenReturn(addClient);
        assertNotNull(clientService.addClient(newClient));
    }

    @Test
    void deleteClient() {
    }

    @Test
    void findById() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        assertNotNull(clientService.findById(1L));
    }

    @Test
    void updateCliente() {
        Client oldClient = new Client(null, "Rosa Mosqueta", 3000);
        Client updateClient = new Client(5L, "Rosa Mosqueta", 3000);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(oldClient));
        when(clientRepository.save(oldClient)).thenReturn(updateClient);
    }

   /* @Test
    void deleteActor() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());
        doNothing().when(actorRepository).delete(actor);
        actorRepository.delete(actor);
        assertFalse(actorRepository.findById(actor.getId()).isPresent());

    }*/
}