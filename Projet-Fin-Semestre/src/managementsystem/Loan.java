package managementsystem;

import users.Borrower;
import utils.Period;
import config.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import equipment.Equipment;

/**
 * Loan class, contains all informations about a loan. A HashMap contains the
 * equipment borrowed as values and the models matching the following values as
 * keys. It also contains the period corresponding to the loan and the borrower.
 * 
 * initial code by : Marc Karassev; modified by : Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public class Loan {
	// TODO tests

	// Fields

	private HashMap<String, ArrayList<Equipment>> stuff;
	private Period period;
	private Borrower borrower;
	private boolean accepted;

	// Constructors
    /**
	 * Default constructor, constructs a loan with an empty HashMap, a default
	 * period and a default Borrower.
	 */
	public Loan() {
		this(new HashMap<String, Integer>(), new Period(), new Borrower());
		accepted = false;
	}

	/**
	 * Constructor used to make a reservation of a model. Constructs a loan with
	 * a HashMap where keys are identical to those of the HashMap given but
	 * where values are ArrayLists of Equipments of size equal to the matching
	 * integer value of the given HashMap.
	 * 
	 * @param stuffAsked
	 *            HashMap where keys are the asked models and values the
	 *            matching wanted number
	 * @param p
	 *            the period of the loan
	 * @param borrower
	 *            the borrower who asks for the loan
	 */
	public Loan(HashMap<String, Integer> stuffAsked, Period p, Borrower borrower) {
		Set<String> keys = stuffAsked.keySet();
		Iterator<String> it = keys.iterator();
		String key;

		stuff = new HashMap<String, ArrayList<Equipment>>(stuffAsked.size());
		while (it.hasNext()) {
			key = it.next();
			stuff.put(key, new ArrayList<Equipment>(stuffAsked.get(key)));
		}
		period = p;
		this.borrower = borrower;
	}

	// Methods

	/**
	 * Returns a string representation of the loan and its fields.
	 */
	@Override
	public String toString() {
		return "stuff: " + stuff + "\nperiod: " + period + "\nborrower: "
				+ borrower;
	}

	// Getters and setters

	/**
	 * Returns the HashMap stuff fields containing the lists of equipment booked
	 * sorted by models.
	 * 
	 * @return the HashMap stuff field
	 */
	public HashMap<String, ArrayList<Equipment>> getStuff() {
		return stuff;
	}

	/**
	 * Returns the period during which the stuff is supposed to be borrowed
	 * according to the loan.
	 * 
	 * @return the period field
	 */
	public Period getPeriod() {
		return period;
	}

	/**
	 * Returns the borrower of the stuff.
	 * 
	 * @return the borrower
	 */
	public Borrower getBorrower() {
		return borrower;
	}

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
