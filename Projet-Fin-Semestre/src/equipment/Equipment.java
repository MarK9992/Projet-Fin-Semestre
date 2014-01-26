package equipment;

import java.io.IOException;
import java.io.Serializable;

import managementsystem.ManagementSystem;

import utils.StoreLoad;

import config.Model;
import config.Models;

/**
 * Super class equipment, defines the common properties to all equipments. An
 * equipment consists of a string ID, a manufacturer and a model. The ID is like
 * "IPAnumber" for an Ipad3 model.
 * 
 * initial code by: Marc Karassev, Anaïs Marongiu; modified by: Anthony Saraïs
 * Marc Karassev
 * 
 * @author Anthony Saraïs, Marc Karassev, Anaïs Marongiu
 * 
 */
public class Equipment implements Serializable {

	// Fields

	private static int counter = 1000;
	private String id;
	private String manufacturer;
	private Model model;

	// Constructors

	/**
	 * Default constructor, constructs a new equipment with unknown model and
	 * manufacturer.
	 * 
	 * @throws IOException
	 */
	public Equipment() throws IOException {

		this("unkwown", ManagementSystem.getManagementSystem().getModels()
				.findModelByName("unknown"));
	}

	/**
	 * Constructs a new equipment with the specified maker and model.
	 * 
	 * @param maker
	 *            its manufacturer
	 * @param model
	 *            the model corresponding to this equipment
	 * @throws IOException
	 */
	public Equipment(String maker, Model model) throws IOException {
		StoreLoad seria = new StoreLoad();

		if (!ManagementSystem.getManagementSystem().getModels().contains(model))
			throw new IllegalArgumentException(
					"Model given does not belong to Models set.");
		try {
			counter = (Integer) seria.Input("Var");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("le fichier Var.data n'existe pas. Creation...");
		}
		this.id = model.getName().substring(0, 3).toUpperCase() + counter;
		this.manufacturer = maker;
		this.model = model;
		counter++;
		seria.Output(counter, "Var");
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
	 * @return the value of the model field
	 */
	public Model getModel() {
		return model;
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
