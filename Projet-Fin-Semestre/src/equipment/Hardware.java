package equipment;

import config.Model;
import config.OS;
import config.Processor;

/**
 * Hardware class. A hardware is an equipment with an operating system, a screen
 * and a processor.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public class Hardware extends Equipment {
	// TODO tests

	// Fields

	private String screenSize;
	private Processor processor;
	private OS os;

	// Constructors

	/**
	 * Default constructor, constructs a new hardware with an ID like
	 * "HW-number", a 10" screen and unknown manufacturer, processor, operating
	 * system and model.
	 */
	public Hardware() {
		this("HW", "unknown", 10, Processor.UNKNOWN, OS.UNKNOWN, Model.UNKWOWN);
	}

	/**
	 * Constructs a new hardware with an ID like "HW-number" and the specified
	 * manufacturer, screen size, processor, operating system and model.
	 * 
	 * @param maker
	 *            the manufacturer of the new hardware
	 * @param screenSize
	 *            its screen size
	 * @param proc
	 *            its processor
	 * @param os
	 *            its operating system
	 * @param type
	 *            its model
	 */
	public Hardware(String maker, double screenSize, Processor proc, OS os,
			Model type) {
		this("HW", maker, screenSize, proc, os, type);
	}

	/**
	 * Constructs a new hardware with the specified id, manufacturer, screen
	 * sire, processor, operating system and model.
	 * 
	 * @param id
	 *            the id of the new hardware
	 * @param maker
	 *            its maker
	 * @param screenSize
	 *            its screen size
	 * @param proc
	 *            its processor
	 * @param os
	 *            its operating system
	 * @param type
	 *            its type
	 */
	public Hardware(String id, String maker, double screenSize, Processor proc,
			OS os, Model type) {
		super(id, maker, type);
		this.screenSize = screenSize + "\"";
		this.processor = proc;
		this.os = os;
	}

	// Methods

	/**
	 * Returns a string representation of the hardware and its values.
	 */
	public String toString() {
		return super.toString() + ", screensize: " + screenSize
				+ ", processor: " + processor.getName() + ", OS: "
				+ os.getName();
	}

	// Getters and Setters

	/**
	 * Returns the hardware's screen size in a string.
	 * 
	 * @return the value of the screenSize field
	 */
	public String getScreenSize() {
		return screenSize;
	}

	/**
	 * Returns the hardware's processor.
	 * @return the value of the processor field
	 */
	public Processor getProcessor() {
		return processor;
	}

	/**
	 * Returns the hardware's operating system.
	 * @return the value of the os field
	 */
	public OS getOs() {
		return os;
	}
}
