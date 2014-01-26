package config;

import java.io.Serializable;

/**
 * Model class, defines the properties of models. They have a name and two
 * limits constants one for quantity and the second for loan duration.
 * 
 * @author Marc Karassev, Anthony Saraïs
 * 
 */
public class Model implements Serializable {

	private String name;
	private final int LOAN_DURATION_LIMIT;
	private final int LOAN_QUANTITY_LIMIT;

	/**
	 * Default constructor, constructs a new Model with an unknown name and
	 * constants set to 0.
	 */
	Model() {
		name = "unknown";
		LOAN_DURATION_LIMIT = 0;
		LOAN_QUANTITY_LIMIT = 0;
	}

	/**
	 * Constructs a new Model with the specified name and limit constants.
	 * 
	 * @param name
	 *            the model's name
	 * @param quantity_limit
	 *            its limit constant referring to loan quantity
	 * @param duration_limit
	 *            its limit constant referring to loan duration
	 */
	Model(String name, int quantity_limit, int duration_limit) {
		this.name = name;
		LOAN_DURATION_LIMIT = duration_limit;
		LOAN_QUANTITY_LIMIT = quantity_limit;
	}

	/**
	 * Returns a string representation of the model and its values.
	 */
	public String toString() {
		return "name: " + name + ", loan duration limit: "
				+ LOAN_DURATION_LIMIT + ", loan quantity limit: "
				+ LOAN_QUANTITY_LIMIT;
	}

	/**
	 * Returns the model's name.
	 * 
	 * @return the value of the name field
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the model's limit referring to loan duration.
	 * 
	 * @return the value of the LOAN_DURATION_LIMIT field
	 */
	public int getLoanDurationLimit() {
		return LOAN_DURATION_LIMIT;
	}

	/**
	 * Returns the model's limit referring to loan quantity.
	 * 
	 * @return the value of the LOAN_QUANTITY_LIMIT field
	 */
	public int getLoanQuantityLimit() {
		return LOAN_QUANTITY_LIMIT;
	}
}
