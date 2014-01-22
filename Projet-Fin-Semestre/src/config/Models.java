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
}