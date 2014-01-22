package config;

/**
 * Enumeration of equipment models.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public enum Model {
	// TODO java doc
	IPAD3("Ipad3"), VENGEANCE2100("Vengeance2100"), XPERIAZ("XperiaZ"), UNKWOWN(
			"unknown");

	private String name;

	private Model(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}