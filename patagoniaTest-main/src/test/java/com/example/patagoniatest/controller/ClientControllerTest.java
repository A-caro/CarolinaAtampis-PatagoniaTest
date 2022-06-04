package com.example.patagoniatest.controller;

import com.example.patagoniatest.model.Client;
import com.example.patagoniatest.repository.ClientRepository;
import com.example.patagoniatest.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class ClientControllerTest {

    @MockBean
    ClientService clientService;

    @MockBean
    ClientRepository clientRepository;
    
   /* @Autowired
    private MockMvc mockMvc;*/
    
    @BeforeEach
    void setUp(){
        
    }
    
    @Test
    void getClients() {
    }

    @Test
    void findById() {
        Client client = new Client(1L,"Menta Alegre", 3000);
        when(clientService.findById(1L)).thenReturn(Optional.of(client));
/*
        mockMvc.perform(MockMvcRequestBuilders.get());*/
    }
}