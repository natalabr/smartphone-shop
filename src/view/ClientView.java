package view;

import controller.ClientController;
import controller.SmartphoneController;
import main.Main;
import persistence.Client;
import persistence.Smartphone;

import java.util.List;
import java.util.Scanner;

public class ClientView {

    ClientController clientController = new ClientController();

    public void clientMenu() {

        boolean clientMenu = true;
        do {

            System.out.println("-------Client Administration Menu-------");
            System.out.println("[1] Show Clients");
            System.out.println("[2] Show Client by id");
            System.out.println("[3] Add Client");
            System.out.println("[4] Delete Client");
            System.out.println("[5] Edit Client");
            System.out.println("[9] Go back to Main Menu");

            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter the number of an Action: ");

            int userInput = myScanner.nextInt();

            switch (userInput) {
                case 1 -> getClients();
                case 2 -> getClient(myScanner);
                case 3 -> addClient(myScanner);
                case 4 -> deleteClient(myScanner);
                case 5 -> updateClient(myScanner);
                case 9 -> clientMenu = backToMainMenu();
            }
        }
        while (clientMenu);
    }

    private static boolean backToMainMenu() {

        boolean smartphoneMenu;
        Main.instance.displayMainMenu();
        smartphoneMenu = false;
        return smartphoneMenu;
    }

    private void updateClient(Scanner myScanner) {

        System.out.println("Enter Client id: ");
        String clientIdToUpdate = myScanner.next();
        Client clientToUpdate = clientController.getClient(clientIdToUpdate);
        if (clientToUpdate == null) {
            System.out.println("Client " + clientIdToUpdate + " does not exist");
            return;
        }
        System.out.println("Enter Client first name: ");
        clientToUpdate.firstname = myScanner.next();
        // TODO: Add rest of the fields
        clientController.updateClient(clientToUpdate);
    }

    private void deleteClient(Scanner myScanner) {

        System.out.println("Enter Client id: ");
        String clientIdToDelete = myScanner.next();
        boolean deleted = clientController.deleteClient(clientIdToDelete);
        if (deleted) {
            System.out.println("Client " + clientIdToDelete + " has been deleted");
        } else {
            System.out.println("Nothing was deleted");
        }
    }

    private void getClients() {

        List<Client> clients = clientController.getClients();
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    private void getClient(Scanner myScanner) {

        System.out.println("Enter Client id: ");
        String clientId = myScanner.next();
        Client client = clientController.getClient(clientId);
        System.out.println(client);
    }

    private void addClient(Scanner myScanner) {

        Client newClient = new Client();
        System.out.println("Enter Client first name: ");
        newClient.firstname = myScanner.next();
        clientController.addClient(newClient);
    }
}
