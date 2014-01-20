package equipment;

import java.util.ArrayList;

import utils.Period;
import config.Model;
import config.OS;
import config.Processor;

/**
 * Class Hardware, defines all common properties to hardware.
 * 
 * @author Marc Karassev
 * 
 */
public class Hardware extends Equipment {
	// TODO java documentation
	// TODO check the use of field unavailabalityPeriods and re-factor the class
	// if necessary
	// TODO tests

	// Fields

	private String screenSize;
	private Processor processor;
	private OS os;

	// Constructors

	public Hardware() {
		this("HW", "unknown", new ArrayList<Period>(), 10, Processor.UNKNOWN,
				OS.UNKNOWN, Model.UNKWOWN);
	}

	public Hardware(String id, String maker, ArrayList<Period> unavPer,
			double screenSize, Processor proc, OS os, Model type) {
		super(id, maker, unavPer, type);
		this.screenSize = screenSize + "\"";
		this.processor = proc;
		this.os = os;
	}

	// Methods

	public String toString() {
		return super.toString() + ", screensize: " + screenSize
				+ ", processor: " + processor.getName() + ", OS: "
				+ os.getName();
	}

	// Getters and Setters

	public String getScreenSize() {
		return screenSize;
	}

	public Processor getProcessor() {
		return processor;
	}

	public OS getOs() {
		return os;
	}
}
