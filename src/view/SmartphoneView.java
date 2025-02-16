package view;

import controller.SmartphoneController;
import main.Main;
import persistence.Smartphone;

import java.util.List;
import java.util.Scanner;


public class SmartphoneView {

    SmartphoneController smartphoneController = new SmartphoneController();

    public void displaySmartphoneMenu() {

        boolean smartphoneMenu = true;
        do {

            System.out.println("-------Smartphone Administration Menu-------");
            System.out.println("[1] Show Smartphones");
            System.out.println("[2] Show Smartphone by id");
            System.out.println("[3] Add Smartphone");
            System.out.println("[4] Delete Smartphone");
            System.out.println("[5] Edit Smartphone");
            System.out.println("[9] Go back to Main Menu");

            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter the number of an Action: ");

            int userInput = myScanner.nextInt();

            switch (userInput) {
                case 1 -> getSmartphones();
                case 2 -> getSmartphone(myScanner);
                case 3 -> addSmartphone(myScanner);
                case 4 -> deleteSmartphone(myScanner);
                case 5 -> updateSmartphone(myScanner);
                case 9 -> smartphoneMenu = backToMainMenu();
            }
        }
        while (smartphoneMenu);
    }

    private static boolean backToMainMenu() {

        boolean smartphoneMenu;
        Main.instance.displayMainMenu();
        smartphoneMenu = false;
        return smartphoneMenu;
    }

    private void updateSmartphone(Scanner myScanner) {

        System.out.println("Enter Smartphone id: ");
        String smartphoneIdToUpdate = myScanner.next();
        Smartphone smartphoneToUpdate = smartphoneController.getSmartphone(smartphoneIdToUpdate);
        if (smartphoneToUpdate == null) {
            System.out.println("Smartphone " + smartphoneIdToUpdate + " does not exist");
            return;
        }
        System.out.println("Enter Smartphone brand: ");
        smartphoneToUpdate.brand = myScanner.next();
        smartphoneController.updateSmartphone(smartphoneToUpdate);
    }

    private void deleteSmartphone(Scanner myScanner) {

        System.out.println("Enter Smartphone id: ");
        String smartphoneIdToDelete = myScanner.next();
        boolean deleted = smartphoneController.deleteSmartphone(smartphoneIdToDelete);
        if (deleted) {
            System.out.println("Smartphone " + smartphoneIdToDelete + " has been deleted");
        } else {
            System.out.println("Nothing was deleted");
        }
    }

    private void getSmartphones() {

        List<Smartphone> smartphones = smartphoneController.getSmartphones();
        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone);
        }
    }

    private void getSmartphone(Scanner myScanner) {

        System.out.println("Enter Smartphone id: ");
        String smartphoneId = myScanner.next();
        Smartphone smartphone = smartphoneController.getSmartphone(smartphoneId);
        System.out.println(smartphone);
    }

    private void addSmartphone(Scanner myScanner) {

        Smartphone newSmartphone = new Smartphone();
        System.out.println("Enter Smartphone brand: ");
        newSmartphone.brand = myScanner.next();
        smartphoneController.addSmartphone(newSmartphone);
    }
}
