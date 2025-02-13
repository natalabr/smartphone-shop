package controller;

import persistence.Client;
import repository.ClientRepository;

import java.util.List;

public class ClientController {

    private ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    public Client getClient(int id) {
        return clientRepository.getClient(id);
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public void updateClient(Client client) {
        clientRepository.updateClient(client);
    }
}
