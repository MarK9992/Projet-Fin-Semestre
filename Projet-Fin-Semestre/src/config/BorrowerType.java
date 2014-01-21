package config;

/**
 * Enumeration of borrower kinds.
 * 
 * @author Marc Karassev
 * 
 */
public enum BorrowerType {
	STUDENT("student"), TEACHER("teacher");

	private String name;

	/**
	 * Constructs a new borrower type with a specified name.
	 * 
	 * @param name
	 *            the name defining the borrower type
	 */
	private BorrowerType(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the borrower type.
	 * 
	 * @return the name defining the borrower type.
	 */
	public String getName() {
		return name;
	}
}
