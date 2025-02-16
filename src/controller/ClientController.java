package controller;

import persistence.Client;
import repository.ClientRepository;

import java.util.List;

public class ClientController {

    private ClientRepository clientRepository = new ClientRepository();

    public List<Client> getClients() {

        return clientRepository.getClients();
    }

    public Client getClient(String id) {

        return clientRepository.getClient(id);
    }

    public boolean updateClient(Client client) {

        Client oldClient = clientRepository.getClient(client.id);
        System.out.println("first name: " + oldClient.firstname + " -> " + client.firstname);
        return clientRepository.updateClient(client);
    }

    public void addClient(Client client) {

        clientRepository.addClient(client);
    }

    public boolean deleteClient(String id) {

        return clientRepository.deleteClient(id);
    }
}
