package config;

/**
 * Enumeration of equipment models.
 * 
 * @author Marc Karassev
 * 
 */
public enum Model {
	// TODO java doc
	IPAD3("Ipad3"), VENGEANCE2100("Vengeance2100"), XPERIAZ("XperiaZ"), UNKWOWN(
			"unkwown");

	private String name;

	private Model(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}