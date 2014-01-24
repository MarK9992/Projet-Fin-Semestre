package config;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

import utils.StoreLoad;

/**
 * Singleton for the set of models available in the management system.
 * 
 * @author Marc Karassev
 * 
 */
public class Models extends HashSet<Model> implements Serializable {
    
	/**
	 * Default constructor, constructs a new set of models with the following
	 * models.
	 */
	public Models() {
		add(new Model("Ipad3", 3, 7));
		add(new Model("Vengeance2100", 12, 10));
		add(new Model("XperiaZ", 1, 7));
		add(new Model("Lit", 4, 12));
		add(new Model("Chaise", 4, 8));
		add(new Model("unknown", 0, 0));
		StoreLoad seria = new StoreLoad();

        try {
            seria.Output(this, "Models");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Returns the current set of models.
	 * 
	 * @return the set of models
	 */
	/*public static Models getModels() {
		return models;
	}*/

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
		StoreLoad seria = new StoreLoad();
        try {
			seria.Output(this, "Models");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Removes a model of the given name from the set.
	 * 
	 * @param model
	 *            the model's to remove name
	 */
	public void removeModel(String model) {
		remove(findModelByName(model));
		StoreLoad seria = new StoreLoad();
        try {
			seria.Output(this, "Models");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void containsModel(Model m) {
		/*if (!contains(m))
			throw new IllegalArgumentException(
					"Model given does not belong to Models set.");*/
	}
}