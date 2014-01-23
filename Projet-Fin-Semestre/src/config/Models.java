package config;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Singleton for the set of models available in the management system.
 * 
 * @author Marc Karassev
 * 
 */
public class Models extends HashSet<Model> {

	private static Models models = new Models();

	/**
	 * Default constructor, constructs a new set of models with the following
	 * models.
	 */
	private Models() {
		add(new Model("Ipad3", 3, 7));
		add(new Model("Vengeance2100", 12, 10));
		add(new Model("XperiaZ", 7, 14));
		add(new Model("unknown", 0, 0));
	}

	/**
	 * Returns the current set of models.
	 * 
	 * @return the set of models
	 */
	public static Models getModels() {
		return models;
	}

	/**
	 * Adds a new model in the models set. The name given should not already
	 * exist in the models set.
	 * 
	 * @param name
	 *            the name of the new model
	 * @param loan_duration_limit
	 *            its loan duration limit constant
	 * @param loan_quantity_limit
	 *            its loan quantity limit constant
	 */
	public void addModel(String name, int loan_duration_limit,
			int loan_quantity_limit) {
		if (findModelByName(name) != null)
			throw new IllegalArgumentException(
					"name of model to add already exists");
		add(new Model(name, loan_duration_limit, loan_quantity_limit));
	}

	/**
	 * Removes a model of the given name from the set.
	 * 
	 * @param model
	 *            the model's to remove name
	 */
	public void removeModel(String model) {
		remove(findModelByName(model));
	}

	/**
	 * Looks for a model in the set of the given name.
	 * 
	 * @param name
	 *            the name of the model to look for
	 * @return the model if found, null otherwise
	 */
	public Model findModelByName(String name) {
		Iterator<Model> it = iterator();
		Model m;

		while (it.hasNext()) {
			m = it.next();
			if (m.getName().equals(name))
				return m;
		}
		return null;
	}

	/**
	 * Method called by methods where a model that should exist in the set is
	 * supposed to be given in parameter. Throws an IllegalArgumentException if
	 * the given model does not belong the models set.
	 * 
	 * @param s
	 *            the model to check
	 */
	public static void containsModel(Model m) {
		if (!models.contains(m))
			throw new IllegalArgumentException(
					"Model given does not belong to Models set.");
	}
}