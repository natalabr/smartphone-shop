package main;

import controller.*;
import view.*;
import persistence.PersistenceService;

import java.util.Scanner;

public class Main {

    public static Main instance;

    public Main() {
        instance = this;
    }

    public static void main(String[] args) {

        Main main = new Main();

        main.displayMainMenu();
    }

    public static void displayMainMenu() {

        boolean mainMenu = true;
        do {

            System.out.println("-------------Main Menu-------------");
            System.out.println("[1] Smartphone Administration Menu");
            System.out.println("[2] Client Administration Menu");
            System.out.println("[3] Order Administration Menu");
            System.out.println("[0] Exit");

            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter the number of Menu: ");

            int userInput = myScanner.nextInt();

            switch (userInput) {
                case 1:
                    SmartphoneView smartphoneView = new SmartphoneView();
                    smartphoneView.displaySmartphoneMenu();
                    mainMenu = false;
                    break;
                case 2:
                    ClientView clientView = new ClientView();
                    clientView.clientMenu();
                    mainMenu = false;
                    break;
                case 3:
                    OrderView orderView = new OrderView();
                    orderView.orderMenu();
                    mainMenu = false;
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
        while (mainMenu);
    }
}
