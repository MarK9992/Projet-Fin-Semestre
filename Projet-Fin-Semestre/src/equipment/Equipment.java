package equipment;

import config.Model;

/**
 * Super class equipment, defines the common properties to all equipments. An
 * equipment consists of a string ID, a manufacturer and a model.
 * 
 * initial code by: Marc Karassev, Anaïs Marongiu; modified by: Marc Karassev
 * 
 * @author Marc Karassev, Anaïs Marongiu
 * 
 */
public abstract class Equipment {

	// Fields
	
	private static int counter = 1;
	private String id;
	private String manufacturer;
	private Model type;

	// Constructors

	/**
	 * Default constructor, constructs a new equipment with an ID like
	 * "E-number" and unknown model and manufacturer.
	 */
	public Equipment() {
		this("E", "unkwown", Model.UNKWOWN);
	}

	/**
	 * Constructs a new equipment with the specified id, maker and model.
	 * 
	 * @param id
	 *            the id of the new equipment
	 * @param maker
	 *            its manufacturer
	 * @param type
	 *            the model corresponding to this equipment
	 */
	public Equipment(String id, String maker, Model type) {
		this.id = id + "-" + counter;
		this.manufacturer = maker;
		this.type = type;
		counter++;
	}

	// Methods

	/**
	 * Returns a string representation of the equipment and its values.
	 */
	@Override
	public String toString() {
		return "ID: " + id + ", made by: " + manufacturer;
	}

	// Getters and setters

	/**
	 * Returns the equipment's ID.
	 * 
	 * @return the value of the id field
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the equipment's manufacturer.
	 * 
	 * @return the value of the manufacturer field
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Returns the equipment's model.
	 * 
	 * @return the value of the equipment field
	 */
	public Model getType() {
		return type;
	}

	/**
	 * Returns the equipment class counter representing the number of
	 * instantiated users.
	 * 
	 * @return the value of the counter field
	 */
	public static int getCounter() {
		return counter;
	}
}
