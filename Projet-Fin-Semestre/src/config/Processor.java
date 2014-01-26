package config;

/**
 * Enumeration for the processors of hardwares of the system. Has a string field
 * to return its name.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public enum Processor {
	ARMCORTEX("ARM Cortex"), APPLEA5X("Apple A5X"), APQ8064("APQ 8064"), UNKNOWN(
			"unknown");

	private String name;

	/**
	 * Constructs a new Processor with the specified name.
	 * 
	 * @param name
	 *            the processor's name
	 */
	private Processor(String name) {
		this.name = name;
	}

	/**
	 * Returns the processor's name.
	 * 
	 * @return the value of the name field
	 */
	public String getName() {
		return name;
	}
}
