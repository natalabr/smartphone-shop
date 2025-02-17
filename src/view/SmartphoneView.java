package view;

import controller.SmartphoneController;
import main.Main;
import persistence.Connectivity;
import persistence.PixelResolution;
import persistence.Smartphone;

import java.time.LocalDate;
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
        System.out.println("Enter Smartphone model: ");
        smartphoneToUpdate.model = myScanner.next();
        System.out.println("Enter Smartphone unit price: ");
        smartphoneToUpdate.unitPrice = Double.parseDouble(myScanner.next());
        System.out.println("Enter Smartphone memory: ");
        smartphoneToUpdate.memory = Integer.parseInt(myScanner.next());
        System.out.println("Enter Smartphone screen size: ");
        smartphoneToUpdate.screenSize = Double.parseDouble(myScanner.next());
        System.out.println("Enter Smartphone storage capacity: ");
        smartphoneToUpdate.storageCapacity = Integer.parseInt(myScanner.next());
        System.out.println("Enter Smartphone operating system: ");
        smartphoneToUpdate.operatingSystem = myScanner.next();
        System.out.println("Enter Smartphone operating system version ");
        smartphoneToUpdate.operatingSystemVersion = myScanner.next();
        System.out.println("Enter pixel resolution - width: ");
        smartphoneToUpdate.pixelResolution = new PixelResolution();
        smartphoneToUpdate.pixelResolution.width = Integer.parseInt(myScanner.next());
        System.out.println("Enter pixel resolution - height: ");
        smartphoneToUpdate.pixelResolution.height = Integer.parseInt(myScanner.next());
        System.out.println("Enter Smartphone number of processor cores: ");
        smartphoneToUpdate.numberOfProcessorCores = myScanner.next();
        System.out.println("Enter Smartphone baterry capacity: ");
        smartphoneToUpdate.batteryCapacity = Integer.parseInt(myScanner.next());

        boolean addConnectivity = true;
        do {
            System.out.println("Possible Smartphone connectivity options: ");
            System.out.println("1 - Bluetooh");
            System.out.println("2 - NFC");
            System.out.println("3 - USB");
            System.out.println("4 - Hotspot");
            System.out.println("5 - WLAN");
            System.out.println("0 - NONE");
            System.out.println("Enter Smartphone connectivity: ");
            smartphoneToUpdate.connectivity = switch (myScanner.nextInt()) {
                case 1 -> Connectivity.BLUETOOTH;
                case 2 -> Connectivity.NFC;
                case 3 -> Connectivity.USB;
                case 4 -> Connectivity.HOTSPOT;
                case 5 -> Connectivity.WLAN;
                default -> Connectivity.NONE;
            };

            System.out.println("Do you want to add another connectivity? Y/N: ");
            addConnectivity = myScanner.next().toLowerCase().equals("y");
        } while (addConnectivity);

        System.out.println("Enter Smartphone celluar standard: ");
        smartphoneToUpdate.celluarStandard = myScanner.next();

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
        System.out.println("Enter Smartphone model: ");
        newSmartphone.model = myScanner.next();
        System.out.println("Enter Smartphone unit price: ");
        newSmartphone.unitPrice = Double.parseDouble(myScanner.next());
        System.out.println("Enter Smartphone memory: ");
        newSmartphone.memory = Integer.parseInt(myScanner.next());
        System.out.println("Enter Smartphone screen size: ");
        newSmartphone.screenSize = Double.parseDouble(myScanner.next());
        System.out.println("Enter Smartphone storage capacity: ");
        newSmartphone.storageCapacity = Integer.parseInt(myScanner.next());
        System.out.println("Enter Smartphone operating system: ");
        newSmartphone.operatingSystem = myScanner.next();
        System.out.println("Enter Smartphone operating system version ");
        newSmartphone.operatingSystemVersion = myScanner.next();
        System.out.println("Enter pixel resolution - width: ");
        newSmartphone.pixelResolution = new PixelResolution();
        newSmartphone.pixelResolution.width = Integer.parseInt(myScanner.next());
        System.out.println("Enter pixel resolution - height: ");
        newSmartphone.pixelResolution.height = Integer.parseInt(myScanner.next());
        System.out.println("Enter Smartphone number of processor cores: ");
        newSmartphone.numberOfProcessorCores = myScanner.next();
        System.out.println("Enter Smartphone baterry capacity: ");
        newSmartphone.batteryCapacity = Integer.parseInt(myScanner.next());

        boolean addConnectivity = true;
        do {
            System.out.println("Possible Smartphone connectivity options: ");
            System.out.println("1 - Bluetooh");
            System.out.println("2 - NFC");
            System.out.println("3 - USB");
            System.out.println("4 - Hotspot");
            System.out.println("5 - WLAN");
            System.out.println("0 - NONE");
            System.out.println("Enter Smartphone connectivity: ");
            newSmartphone.connectivity = switch (myScanner.nextInt()) {
                case 1 -> Connectivity.BLUETOOTH;
                case 2 -> Connectivity.NFC;
                case 3 -> Connectivity.USB;
                case 4 -> Connectivity.HOTSPOT;
                case 5 -> Connectivity.WLAN;
                default -> Connectivity.NONE;
            };

            System.out.println("Do you want to add another connectivity? Y/N: ");
            addConnectivity = myScanner.next().toLowerCase().equals("y");
        } while (addConnectivity);

        System.out.println("Enter Smartphone celluar standard: ");
        newSmartphone.celluarStandard = myScanner.next();

        smartphoneController.addSmartphone(newSmartphone);
    }
}
