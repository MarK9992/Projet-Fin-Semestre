package managementsystem;

import users.Borrower;
import utils.Period;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import config.Model;
import config.Models;

import equipment.Equipment;

/**
 * Loan class, contains all informations about a loan. A HashMap contains the
 * equipment borrowed as values and the models matching the values as keys. It
 * also contains the period corresponding to the loan, the borrower and a
 * boolean value in relation to the return of the loan.
 * 
 * A Loan is constructed with an Ask class instance. The period and borrower
 * fields are copied and the Loan's HashMap field is filled with the same key
 * set as the Ask's one but the values are the corresponding equipments.
 * 
 * Should be a super class for Ask and Loan.
 * 
 * initial code by : Marc Karassev; modified by : Marc Karassev, Anthony Saraïs
 * 
 * @author Marc Karassev, Anthony Saraïs
 * 
 */
public class Loan implements Serializable {
	// TODO tests

	// Fields

	private HashMap<Model, ArrayList<Equipment>> stuff;
	private Period period;
	private Borrower borrower;
	private boolean givenBack;

	// Constructors
	/**
	 * Default constructor, constructs a new Loan with a default ask.
	 */
	public Loan() {
		this(new Ask());
	}

	/**
	 * Constructs a new loan by using the specified ask.
	 * 
	 * @param ask
	 *            the ask characterizing the loan
	 */
	public Loan(Ask ask) {
		HashMap<Model, Integer> stuffAsked = ask.getAskedStuff();
		Set<Model> keys = stuffAsked.keySet();
		Iterator<Model> it = keys.iterator();
		Model key;

		stuff = new HashMap<Model, ArrayList<Equipment>>(stuffAsked.size());
		while (it.hasNext()) {
			key = it.next();
			ManagementSystem.getManagementSystem().getModels()
					.containsModel(key);
			stuff.put(key, new ArrayList<Equipment>(stuffAsked.get(key)));
		}
		period = ask.getPeriod();
		borrower = ask.getBorrower();
		givenBack = false;
	}

	// Methods

	/**
	 * Adds an equipment to the askedStuff field.
	 * 
	 * @param e
	 *            the equipment to add
	 */
	public void addEquipment(Equipment e) {
		containsModel(e.getModel());
		// TODO check if more stuff is added than intended
		stuff.get(e.getModel()).add(e);
	}

	/**
	 * Removes the given equipment from the askedStuff field.
	 * 
	 * @param e
	 *            the equipment to remove
	 */
	public void remove(Equipment e) {
		containsModel(e.getModel());
		stuff.get(e.getModel()).remove(e);
	}

	/**
	 * Method called by methods treating with an equipment of given model that
	 * should be in the askedStuff field. Throws an IllegalArgumentException if
	 * this model wasn't asked at the loan creation.
	 * 
	 * @param model
	 *            the model to look for
	 */
	private void containsModel(Model model) {
		Set<Model> keys = stuff.keySet();

		if (!keys.contains(model))
			throw new IllegalArgumentException(
					"Model looked for in loan was not asked.");
	}

	/**
	 * Returns a description of the current status of the loan.
	 * 
	 * @return a string description of its status
	 */
	public String status() {
		if (period.today())
			return "ongoing";
		if (period.daysFromNow() < 0)
			return "not begun";
		if (givenBack)
			return "returned";
		return "not returned yet";
	}

	/**
	 * Returns a string representation of the loan and its fields.
	 */
	@Override
	public String toString() {
		return "stuff: " + stuff + "\nperiod: " + period + "\nborrower: "
				+ borrower + "\ngivenBack: " + givenBack;
	}

	// Getters and setters

	/**
	 * Returns the HashMap stuff fields containing the lists of equipment booked
	 * sorted by models.
	 * 
	 * @return the HashMap stuff field
	 */
	public HashMap<Model, ArrayList<Equipment>> getStuff() {
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

	/**
	 * Returns the return of the loan. If the borrower gave the borrowed stuff
	 * back or not.
	 * 
	 * @return true if it is, false otherwise
	 */
	public boolean getGivenBack() {
		return givenBack;
	}

	/**
	 * Sets the return of the loan.
	 * 
	 * @param b
	 *            the new value for the givenBack field
	 */
	public void setGivenBack(Boolean b) {
		givenBack = b;
	}
}
