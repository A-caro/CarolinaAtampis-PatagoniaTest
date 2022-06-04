package com.example.patagoniatest.service;

import com.example.patagoniatest.model.Client;
import com.example.patagoniatest.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientServiceTest {
    Client client;


    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientService clientService;

    @BeforeEach
    void setUp() {
        client = new Client(1L, "Menta Alegre", 3000);
    }

    @Test
    void getClients() {
    }

    @Test
    void addClient() {
    }

    @Test
    void deleteClient() {
    }

    @Test
    void findById() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
//        assertNotNull();
    }

    @Test
    void updateCliente() {
    }
}