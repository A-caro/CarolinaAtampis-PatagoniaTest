package com.example.patagoniatest.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client;

    @BeforeEach
    void setUp() {
        client = new Client(1L, "Agustina Vermucci", 2000);
    }

    @Test
    void getId() {
        assertTrue(client.getId() == 1);
        assertEquals(1, client.getId());
    }

    @Test
    void getFullName() {
        assertEquals("Agustina Vermucci", client.getFullName());
    }

    @Test
    void getIncome() {
        assertEquals(2000, client.getIncome());
    }

    @Test
    void setId() {
        client.setId(1L);
        assertEquals(1, client.getId());
    }

    @Test
    void setFullName() {
        client.setFullName("Agustina Vermucci");
        assertEquals("Agustina Vermucci", client.getFullName());
    }

    @Test
    void setIncome() {
        client.setIncome(2000);
        assertEquals(2000, client.getIncome());
    }

    @Test
    void testToString() {
        Client client = new Client(1L, "Agustina Vermucci", 2000);
        assertEquals("Client(id=1, fullName=Agustina Vermucci, income=2000)",client.toString());
    }
}