package repository;

import persistence.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneRepository {

    private List<Smartphone> smartphones = new ArrayList<>();

    public List<Smartphone> getSmartphones() {
        return smartphones;
    }

    public Smartphone getSmartphone(int id) {
        for (Smartphone smartphone : smartphones) {

        }
        return null;
    }

    public void updateSmartphone(Smartphone smartphone) {}

    public void addSmartphone(Smartphone smartphone) {}

    public void deleteSmartphone(int id) {}
}
