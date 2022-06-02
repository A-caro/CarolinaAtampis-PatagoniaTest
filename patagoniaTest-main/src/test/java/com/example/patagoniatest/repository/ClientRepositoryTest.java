package com.example.patagoniatest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //permite conectarse al repositorio y poder utilizarlo
class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;

    @Test
    void findById (){
        assertTrue(clientRepository.findById(2L).isPresent());
    }


}