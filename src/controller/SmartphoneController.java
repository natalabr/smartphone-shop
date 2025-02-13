package controller;

import persistence.Smartphone;
import repository.SmartphoneRepository;

import java.util.List;

public class SmartphoneController {

    private SmartphoneRepository smartphoneRepository;

    public List<Smartphone> getSmartphones() {
        return smartphoneRepository.getSmartphones();
    }

    public Smartphone getSmartphone(int id) {
        return smartphoneRepository.getSmartphone(id);
    }

    public void updateSmartphone(Smartphone smartphone) {
        smartphoneRepository.updateSmartphone(smartphone);
    }

    public void addSmartphone(Smartphone smartphone) {
        smartphoneRepository.addSmartphone(smartphone);
    }

    public void deleteSmartphone(int id) {
        smartphoneRepository.deleteSmartphone(id);
    }
}
