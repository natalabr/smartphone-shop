package persistence;

public class Smartphone {

    public String brand;
    public String model;
    public double unitPrice;
    public int memory;
    public int screenSize;
    public int storageCapacity;
    public String operatingSystem;
    public String operatingSystemVersion;
    public int pixelResolution;
    public String numberOfProcessorCores;
    public int batteryCapacity;
    public Connectivity connectivity;
    public String celluarStandard;

    public String toString() {
        return brand + " " + model + " " + unitPrice;
    }
}
