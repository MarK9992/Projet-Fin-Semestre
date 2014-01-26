package managementsystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.Serializable;

import users.Borrower;
import utils.Period;

import config.Model;
import config.Models;

/**
 * Ask class, an ask is an ask for a loan made by a borrower. Its
 * characteristics are an HashMap<Model, Integer> where keys are the models
 * asked for and the values the corresponding quantity, a period and the
 * borrower who made the ask.
 * 
 * @author Marc Karassev, Anthony Saraïs
 * 
 */
public class Ask implements Serializable {

	// Fields

	private HashMap<Model, Integer> askedStuff;
	private Period period;
	private Borrower borrower;

	// Constructors

	/**
	 * Default constructor, constructs an ask with an empty HashMap for the
	 * asked stuff, and default period and borrower.
	 */
	public Ask() {
		this(new HashMap<Model, Integer>(), new Period(), new Borrower());
	}

	/**
	 * Constructs a new ask with the specified HashMap for the asked stuff,
	 * period and borrower.
	 * 
	 * @param aS
	 *            the HashMap<Model, Integer> for the asked stuff.
	 * @param p
	 *            the Ask's period
	 * @param b
	 *            its borrower
	 */
	public Ask(HashMap<Model, Integer> aS, Period p, Borrower b) {
		Set<Model> keys = aS.keySet();
		Iterator<Model> it = keys.iterator();
		Model model;

		while (it.hasNext()) {
			model = it.next();
			ManagementSystem.getManagementSystem().getModels()
					.containsModel(model);
		}
		askedStuff = aS;
		period = p;
		borrower = b;
	}

	// Methods

	/**
	 * Returns a string representation of the ask and its fields.
	 */
	public String toString() {
		return "Asked stuff: " + askedStuff + ", period: " + period
				+ ", borrower: " + borrower;
	}

	// Getters and setters

	/**
	 * Returns the HashMap representing the asked stuff.
	 * 
	 * @return the value of the askedStuff field
	 */
	public HashMap<Model, Integer> getAskedStuff() {
		return askedStuff;
	}

	/**
	 * Returns the period the stuff is asked for.
	 * 
	 * @return the value of the period field
	 */
	public Period getPeriod() {
		return period;
	}

	/**
	 * Returns the borrower of the stuff.
	 * 
	 * @return the value of the borrower field
	 */
	public Borrower getBorrower() {
		return borrower;
	}
}
