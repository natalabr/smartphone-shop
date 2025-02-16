package controller;

import persistence.Smartphone;
import repository.SmartphoneRepository;

import java.util.List;

public class SmartphoneController {

    private SmartphoneRepository smartphoneRepository = new SmartphoneRepository();

    public List<Smartphone> getSmartphones() {

        return smartphoneRepository.getSmartphones();
    }

    public Smartphone getSmartphone(String id) {

        return smartphoneRepository.getSmartphone(id);
    }

    public boolean updateSmartphone(Smartphone smartphone) {

        Smartphone oldSmartphone = smartphoneRepository.getSmartphone(smartphone.id);
        System.out.println("brand: " + oldSmartphone.brand + " -> " + smartphone.brand);
        return smartphoneRepository.updateSmartphone(smartphone);
    }

    public void addSmartphone(Smartphone smartphone) {

        smartphoneRepository.addSmartphone(smartphone);
    }

    public boolean deleteSmartphone(String id) {

        return smartphoneRepository.deleteSmartphone(id);
    }
}
