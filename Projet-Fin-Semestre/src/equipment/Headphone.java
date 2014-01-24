package equipment;

import java.io.IOException;

import config.Model;
import config.Models;

/**
 * Headphone class. A headphone is an equipment with an impedance, a
 * frequencyResponse and a soundPressure.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public abstract class Headphone extends Equipment {
	// TODO tests

	// Fields

	private String impedance;
	private String frequencyResponse;
	private String soundPressure;

	// Constructors

	/**
	 * Default constructor, constructs a new headphone with an impedance of 30
	 * Ohms, a frequency response of 20 to 20000 Hz, a sound pressure of 100 dB
	 * and unknown manufacturer and model.
	 * 
	 * @throws IOException
	 */
	public Headphone() throws IOException {
		this("unknown", 30, "20-20000", 100, Models.getModels()
				.findModelByName("unknown"));
	}

	/**
	 * Constructs a new headphone with the specified manufacturer, impedance,
	 * frequency response, sound pressure and model.
	 * 
	 * @param maker
	 *            its manufacturer
	 * @param imp
	 *            its impedance
	 * @param resp
	 *            its frequency response
	 * @param pres
	 *            its sound pressure
	 * @param type
	 *            its model
	 * @throws IOException
	 */
	public Headphone(String maker, int imp, String resp, int pres, Model type)
			throws IOException {
		super(maker, type);
		impedance = imp + " Ohms";
		frequencyResponse = resp + " Hz";
		soundPressure = pres + " dB";
	}

	// Methods

	/**
	 * Returns a string representation of the headphone and its values.
	 */
	public String toString() {
		return super.toString() + ", impedance: " + impedance
				+ ", frequency response: " + frequencyResponse
				+ ", sound pressure: " + soundPressure;
	}

	// Getters and setters

	/**
	 * Returns the headphone's impedance.
	 * 
	 * @return the value of the impedance field.
	 */
	public String getImpedance() {
		return impedance;
	}

	/**
	 * Returns the headphone's frequency response.
	 * 
	 * @return the value of the frequencyResponse field
	 */
	public String getFrequencyResponse() {
		return frequencyResponse;
	}

	/**
	 * Returns the headphone's sound pressure.
	 * 
	 * @return the value of the soundPressure field.
	 */
	public String getSoundPressure() {
		return soundPressure;
	}
}
