package equipment;

import java.io.Serializable;

import config.Model;

/**
 * Super class equipment, defines the common properties to all equipments. An
 * equipment consists of a string ID, a manufacturer and a model. The ID is like
 * "IPAnumber" for an Ipad3 model.
 * 
 * initial code by: Marc Karassev, Anaïs Marongiu; modified by: Marc Karassev
 * 
 * @author Marc Karassev, Anaïs Marongiu
 * 
 */
public class Equipment{

	// Fields

	private static int counter = 1000;
	private String id;
	private String manufacturer;
	private Model type;

	// Constructors

	/**
	 * Default constructor, constructs a new equipment with unknown model and
	 * manufacturer.
	 */
	public Equipment() {
		this("unkwown", Model.UNKNOWN);
	}

	/**
	 * Constructs a new equipment with the specified maker and model.
	 * 
	 * @param maker
	 *            its manufacturer
	 * @param type
	 *            the model corresponding to this equipment
	 */
	public Equipment(String maker, Model type) {
		this.id = type.getName().substring(0, 3).toUpperCase() + counter;
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
