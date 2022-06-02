package com.example.patagoniatest.service;

import com.example.patagoniatest.model.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {

    @Test
    void getClients() {
        Client client = new Client(1L, "Ernestina Ocampo", 2000);
        assertEquals(1, client.getId());
        assertEquals("Ernestina Ocampo", client.getFullName());
       /* assertTrue(client.getFullName() == "Ernestina Ocampo");
        assertTrue(client.getId() == 1L);
        assertTrue(client.getIncome() == 2000);*/
    }

    @Test
    void addClient() {
    }

    @Test
    void deleteClient() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateCliente() {
    }
}