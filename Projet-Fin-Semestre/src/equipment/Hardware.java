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
	 * Default constructor, constructs a new hardware with a 10" screen and
	 * unknown manufacturer, processor, operating system and model.
	 */
	public Hardware() {
		this("unknown", 10, Processor.UNKNOWN, OS.UNKNOWN, Model.UNKNOWN);
	}

	/**
	 * Constructs a new hardware with the manufacturer, screen sire, processor,
	 * operating system and model.
	 * 
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
	public Hardware(String maker, double screenSize, Processor proc, OS os,
			Model type) {
		super(maker, type);
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
	 * 
	 * @return the value of the processor field
	 */
	public Processor getProcessor() {
		return processor;
	}

	/**
	 * Returns the hardware's operating system.
	 * 
	 * @return the value of the os field
	 */
	public OS getOs() {
		return os;
	}
}
