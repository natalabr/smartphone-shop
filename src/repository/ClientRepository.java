package repository;

import persistence.Client;
import persistence.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private List<Client> clients = new ArrayList<>();

    public List<Client> getClients() {

        //TODO take clients from db
        return clients;
    }

    public Client getClient(int id) {
        for (Client client : clients) {

        }
        return null;
    }

    public void addClient(Client client) {}

    public void updateClient(Client client) {}

}
