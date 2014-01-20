package config;

/**
 * Enumeration for the OS of hardwares of the system.
 * 
 * @author Marc Karassev
 * 
 */
public enum OS {
	// TODO java documentation
	IOS5("iOS_5"), ANDROID41("Android 4.1"), ANDROID43("Android 4.3"), UNKNOWN(
			"unknown");

	private String name;

	private OS(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}