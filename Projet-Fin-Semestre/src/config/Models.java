package config;

import java.util.HashSet;

/**
 * Singleton for the set of models available in the management system.
 * 
 * @author Marc Karassev
 * 
 */
public class Models extends HashSet<String> {

	private static Models models = new Models();

	private Models() {
		add("Ipad3");
		add("Vengeance2100");
		add("XperiaZ");
		add("unknown");
	}

	public static Models getModels() {
		return models;
	}

	/**
	 * Method called by methods where a model string is supposed to be given in
	 * parameter. Throws an IllegalArgumentException if the given model does not
	 * belong the models set.
	 * 
	 * @param s
	 *            the model string to check
	 */
	public static void containsModel(String s) {
		if (!models.contains(s))
			throw new IllegalArgumentException(
					"Model gicen does not belong to Models set.");
	}
}