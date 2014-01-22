package config;

import java.util.HashSet;

/**
 * Enumeration of equipment models.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public class Models extends HashSet<String> {
	
	public static Models models = new Models();

	private Models() {
		add("Ipad3");
		add("Vengeance2100");
		add("XperiaZ");
		add("unknown");
	}
}