package persistence;

public class Smartphone {

    public String id;
    public String brand;
    public String model;
    public double unitPrice;
    public int memory;
    public double screenSize;
    public int storageCapacity;
    public String operatingSystem;
    public String operatingSystemVersion;
    public PixelResolution pixelResolution;
    public String numberOfProcessorCores;
    public int batteryCapacity;
    public Connectivity connectivity;
    public String celluarStandard;

    @Override
    public String toString() {
        return id + ": " + brand + " " + model + " " + unitPrice;
    }
}
