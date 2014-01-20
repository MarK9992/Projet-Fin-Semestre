package config;

/**
 * Enum for the processors of hardwares of the system.
 * @author Marc
 *
 */
public enum Processor {
    ARMCORTEX("ARM Cortex"), APPLEA5X("Apple A5X"), APQ8064("APQ 8064");

    private String name;

    private Processor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
