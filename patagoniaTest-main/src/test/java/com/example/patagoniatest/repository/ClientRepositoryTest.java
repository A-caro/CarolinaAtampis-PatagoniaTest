package com.example.patagoniatest.repository;

import com.example.patagoniatest.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //permite conectarse al repositorio y poder utilizarlo
class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @Test
    void findById(){
        assertTrue(clientRepository.findById(12L).isPresent());
        assertEquals("Potus Alegre", clientRepository.findById(12L).get().getFullName());
    }
    
    @Test
    void create(){
        Client client = new Client(13L,"Menta Alegre", 2900);
        Client clientSave = clientRepository.save(client);
        assertTrue(clientSave.getId() > 0);
    }

}