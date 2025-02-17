package persistence;

public enum Connectivity {
    NONE ("none"),
    BLUETOOTH ("Bluetooth"),
    NFC ("NFC"),
    USB ("USB"),
    HOTSPOT ("Hotspot"),
    WLAN ("WLAN");

    private final String name;

    private Connectivity(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }
}
