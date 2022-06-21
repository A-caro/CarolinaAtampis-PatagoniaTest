package com.example.patagoniatest.controller;

import com.example.patagoniatest.model.Client;
import com.example.patagoniatest.repository.ClientRepository;
import com.example.patagoniatest.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
class ClientControllerTest {

    @MockBean //simula al servidor
    ClientService clientService;

    @MockBean
    ClientRepository clientRepository;
    
    @Autowired
    private MockMvc mockMvc;
    
    @BeforeEach
    void setUp(){

    }
    
    @Test
    void getClients() throws Exception {
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client(1L, "Menta Alegre", 3000));
        clientList.add(new Client(2L, "Potus Alegre", 3000));
        when(clientService.getClients()).thenReturn(clientList);
        mockMvc.perform(MockMvcRequestBuilders.get("/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
              /*  .andExpect(jsonPath("[0].fullName").value("Menta Alegre"))
                 .andExpect(jsonPath("[1].fullName").value("Potus Alegre"));*/


    }

    @Test
    void findById() throws Exception {
        Client client = new Client(1L,"Menta Alegre", 3000);
        when(clientService.findById(1L)).thenReturn(Optional.of(client));
        mockMvc.perform(MockMvcRequestBuilders.get("/clients/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }
}