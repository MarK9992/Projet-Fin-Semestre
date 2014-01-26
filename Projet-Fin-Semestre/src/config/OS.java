package config;

/**
 * Enumeration for the OS of hardwares of the system. Has a string field to
 * return its name.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public enum OS {
	IOS5("iOS_5"), ANDROID41("Android 4.1"), ANDROID43("Android 4.3"), UNKNOWN(
			"unknown");

	private String name;

	/**
	 * Constructs a new OS with the specified name.
	 * 
	 * @param name
	 *            the new OS's name
	 */
	private OS(String name) {
		this.name = name;
	}

	/**
	 * Returns the OS's name.
	 * 
	 * @return the value of the OS field
	 */
	public String getName() {
		return name;
	}
}