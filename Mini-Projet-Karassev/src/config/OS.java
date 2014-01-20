package config;

/**
 * Enum for the OS of hardwares of the system.
 * @author Marc
 * 
 */
public enum OS {
    IOS5("iOS_5"), ANDROID41("Android 4.1"), ANDROID43("Android 4.3");

    private String name;

    private OS(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}