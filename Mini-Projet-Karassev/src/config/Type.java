package config;

/**
 * Enum for the type of the equipments of the system.
 * @author Anaïs
 *
 */
public enum Type {
    PAD("PAD"), SMARTPHONE("Smartphone"), HEADPHONE("Headphone"), UNKWOWN(
            "Unkwown");

    private String name;

    private Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}