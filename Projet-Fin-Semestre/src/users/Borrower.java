package users;

import managementsystem.Loan;
import utils.Period;
import config.BorrowerType;
import config.Model;

/**
 * Borrower class, a user who can borrow equipments.
 * 
 * @author Marc Karassev
 * 
 */
public class Borrower extends User {
	// TODO java doc
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
	 * Asks for an equipment of specified model and period. Creates a new loan
	 * corresponding to these standarts.
	 * 
	 * @param m
	 *            model of the wanted equipment
	 * @param p
	 *            period asked for the loan
	 * @return the loan instance created
	 */
	public Loan book(Model m, Period p) {
		Loan l = new Loan(m, p, this);
		return l;
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
		return super.toString() + ", type: " + type.getName();
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
