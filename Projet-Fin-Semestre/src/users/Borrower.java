package users;

import java.io.Serializable;
import java.util.HashMap;

import managementsystem.Ask;
import utils.Period;
import utils.StoreLoad;
import config.BorrowerType;
import config.Model;

/**
 * Borrower class, a user who can borrow equipments.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public class Borrower extends User implements Serializable {
	// TODO tests

	// Fields

	private BorrowerType type;

	// Constructors

	/**
	 * Default constructor, constructs a borrower of type student with an
	 * unknown name.
	 */
	public Borrower() {
		this("B", "unknown", BorrowerType.STUDENT);
	}

	/**
	 * Constructs a new borrower with an id like "B-number" and the specified
	 * name and type.
	 * 
	 * @param n
	 *            name of the new borrower
	 * @param bt
	 *            type of the new borrower
	 */
	public Borrower(String n, BorrowerType bt) {
		this("B", n, bt);
	}

	/**
	 * Constructs a new borrower with the specified id, name and type.
	 * 
	 * @param i
	 *            string representing the id of the new borrower
	 * @param n
	 *            name of the new borrower
	 * @param bt
	 *            type of the new borrower
	 */
	public Borrower(String i, String n, BorrowerType bt) {
		super(i, n);
		type = bt;
	}

	// Methods

	/**
	 * Asks for equipments of specified models and for a period. Creates a new
	 * ask corresponding to these standards.
	 * 
	 * The ask should be added to the management system here instead of in the
	 * controllers.
	 * 
	 * @param askedStuff
	 *            HashMap in which keys are models and values the asked number
	 *            of equipment of matching model
	 * @param p
	 *            period asked for the loan
	 * @return the loan instance created
	 */
	public Ask book(HashMap<Model, Integer> askedStuff, Period p) {
		Ask a = new Ask(askedStuff, p, this);
		return a;
	}

	/*
	 * /** Gives back the equipment borrowed in Loan l.
	 * 
	 * @param l
	 */
	// TODO public void giveBack(Loan l);

	/**
	 * Returns a string representation of the instance and its values.
	 */
	public String toString() {
		return "Borrower: " + super.toString() + ", type: " + type.getName();
	}

	// Getters and setters

	/**
	 * Returns the borrower type corresponding to the instance.
	 * 
	 * @return the BorrowerType
	 */
	public BorrowerType getType() {
		return type;
	}

	/**
	 * Sets the type of the borrower.
	 * 
	 * @param bt
	 *            the new BorrowerType
	 */
	public void setType(BorrowerType bt) {
		type = bt;
	}
}
