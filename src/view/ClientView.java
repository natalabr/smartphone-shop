package view;

import controller.ClientController;
import controller.SmartphoneController;
import main.Main;
import persistence.Adress;
import persistence.Client;
import persistence.PixelResolution;
import persistence.Smartphone;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ClientView {

    ClientController clientController = new ClientController();
    Adress adress = new Adress();

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

        System.out.println("Enter Client salutation: ");
        clientToUpdate.salutation = myScanner.next();
        System.out.println("Enter Client first name: ");
        clientToUpdate.firstname = myScanner.next();
        System.out.println("Enter Client last name: ");
        clientToUpdate.lastname = myScanner.next();
        System.out.println("Enter Client private phone number: ");
        clientToUpdate.privatePhoneNumber = myScanner.next();
        System.out.println("Enter Client mobile phone number: ");
        clientToUpdate.mobilePhoneNumber = myScanner.next();
        System.out.println("Enter Client email: ");
        clientToUpdate.emailAdress = myScanner.next();
        System.out.println("Enter Client dateOfBirth: ");
        clientToUpdate.dateOfBirth = LocalDate.parse(myScanner.next());
        System.out.println("Enter Client username: ");
        clientToUpdate.username = myScanner.next();
        System.out.println("Enter Client password: ");
        clientToUpdate.password = myScanner.next();
        System.out.println("Enter Client address - city: ");
        clientToUpdate.adress = new Adress();
        clientToUpdate.adress.city = myScanner.next();
        System.out.println("Enter Client address - street: ");
        clientToUpdate.adress.street = myScanner.next();
        System.out.println("Enter Client address - zip code: ");
        clientToUpdate.adress.zipCode = myScanner.next();
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
        System.out.println("Enter Client salutation: ");
        newClient.salutation = myScanner.next();
        System.out.println("Enter Client first name: ");
        newClient.firstname = myScanner.next();
        System.out.println("Enter Client last name: ");
        newClient.lastname = myScanner.next();
        System.out.println("Enter Client private phone number: ");
        newClient.privatePhoneNumber = myScanner.next();
        System.out.println("Enter Client mobile phone number: ");
        newClient.mobilePhoneNumber = myScanner.next();
        System.out.println("Enter Client email: ");
        newClient.emailAdress = myScanner.next();
        System.out.println("Enter Client dateOfBirth: ");
        newClient.dateOfBirth = LocalDate.parse(myScanner.next());
        System.out.println("Enter Client username: ");
        newClient.username = myScanner.next();
        System.out.println("Enter Client password: ");
        newClient.password = myScanner.next();
        System.out.println("Enter Client address - city: ");
        newClient.adress = new Adress();
        newClient.adress.city = myScanner.next();
        System.out.println("Enter Client address - street: ");
        adress.street = myScanner.next();
        System.out.println("Enter Client address - zip code: ");
        adress.zipCode = myScanner.next();
        clientController.addClient(newClient);
    }
}
