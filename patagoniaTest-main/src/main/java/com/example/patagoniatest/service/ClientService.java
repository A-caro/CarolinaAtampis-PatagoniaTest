package com.example.patagoniatest.service;

import com.example.patagoniatest.model.Client;
import com.example.patagoniatest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public void updateCliente(Long id, Client cliente){
        Optional<Client> client = clientRepository.findById(id);
        try{
            client.isPresent();
            if (!client.get().equals(cliente.getFullName())){
                client.get().setFullName(cliente.getFullName());
            } if(client.get().equals(cliente.getIncome())){
                client.get().setIncome(cliente.getIncome());
            }
    }catch (IllegalStateException e){
            System.out.println("El id solicitado no existe" + e.getMessage());
        }
        clientRepository.save(client.get());
    }




    public OptionalDouble getEarningsAverage() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .mapToDouble(Client::getIncome)
                .average();
    }

    public List<Client> getPromedio() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().filter(client -> client.getIncome() >= 10000)
                .collect(Collectors.toList());
    }

}

