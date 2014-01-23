package users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import utils.Period;

import managementsystem.Loan;
import managementsystem.ManagementSystem;
import config.BorrowerConstants;
import equipment.Equipment;

/**
 * Manager class, a user who can manage the inventory and validate or refuse
 * loans. He also controls the state of loans.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public class Manager extends User implements BorrowerConstants, Serializable {
	// TODO extensibility
	// TODO tests

	// Constructors

	/**
	 * Default constructor, constructs a new Manager with an ID like "M-number"
	 * and an unknown name.
	 */
	public Manager() {
		this("M", "unknown");
	}

	/**
	 * Constructs a new Manager with an ID like "M-number" and a specified name.
	 * 
	 * @param n
	 *            the name of the new manager
	 */
	public Manager(String n) {
		this("M", n);
	}

	/**
	 * Constructs a new Manager with the specified ID and name.
	 * 
	 * @param i
	 *            the ID of the manager
	 * @param n
	 *            his name
	 */
	public Manager(String i, String n) {
		super(i, n);
	}

	// Methods

	/**
	 * Accepts the given loan by setting its accepted field to true.
	 * 
	 * @param loan
	 *            the loan to accept
	 */
	public void accept(Loan loan) {
		loan.setAccepted(true);
	}

	/**
	 * Checks if the loan is valid.
	 * 
	 * @param l
	 * 
	 * @param i
	 */
	public void checkLoan(Loan l, ManagementSystem ms) {
		if (l == null || ms == null)
			throw new IllegalArgumentException("null arguments");
		Borrower bwer = l.getBorrower();
		Period period = l.getPeriod();
		HashMap<String, ArrayList<Equipment>> askedStuff = l.getStuff();
		if (bwer == null || period == null || askedStuff == null
				|| askedStuff.isEmpty())
			throw new IllegalArgumentException("null argument fields");
		final int LOAN_DURATION_LIMIT;
		final int LOAN_RESERVATION_LIMIT;
		int current_equipment_number_limit;
		int current_equipment_duration_limit;
		String current_model;
		Set<String> keys = askedStuff.keySet();
		Iterator<String> it = keys.iterator();

		setBorrowerConstants(bwer, LOAN_DURATION_LIMIT, LOAN_RESERVATION_LIMIT);
		if (period.getDuration() > LOAN_DURATION_LIMIT
				|| period.daysFromNow() > LOAN_RESERVATION_LIMIT) {
			l.setAccepted(false);
			// TODO call of a method altering the loan to satisfy these
			// standards
			return;
		}

		while (it.hasNext()) {
			current_model = it.next();
			for (Equipment e : askedStuff.get(current_model))
				setEquipmentConstants(e, current_equipment_duration_limit,
						current_equipment_number_limit);
		}
		// Updates the stuff, the loan and the borrower
		stuff.getUnavailabalityPeriods().add(period);
		l.setEquipmentID(stuff.getId());
		return true;
	}

	/**
	 * Sets the given limits according to the given borrower's type.
	 * 
	 * @param bwer
	 *            the borrower according the limits have to be set
	 * @param duration_limit
	 *            the loan duration limit
	 * @param reservation_limit
	 *            the loan reservation limit
	 */
	private void setBorrowerConstants(Borrower bwer, int duration_limit,
			int reservation_limit) {
		if (bwer.getType().equals("teacher")) {
			duration_limit = TEACHER_LOAN_DURATION_LIMIT;
			reservation_limit = TEACHER_LOAN_RESERVATION_LIMIT;
		} else {
			duration_limit = STUDENT_LOAN_DURATION_LIMIT;
			reservation_limit = STUDENT_LOAN_RESERVATION_LIMIT;
		}
	}

	private void setEquipmentConstants(Equipment e, int duration_limit,
			int number_limit) {
		
	}

	/*
	 * TODO update in relation to the new HashMap field of Loan class /** Puts
	 * away a loan, updates references of the loanList, and the equipment
	 * concerned.
	 * 
	 * @param loan
	 * 
	 * @param list
	 * 
	 * @param i inventory where the equipment concerned by the loan is
	 * referenced
	 * 
	 * @return the loan list updated
	 */
	// TODO use of list parameter ?
	/*
	 * public ArrayList<Loan> putAway(Loan loan, ArrayList<Loan> list, Inventory
	 * i) { list.remove(loan);
	 * i.findEquipmentByID(loan.getEquipmentID()).getUnavailabalityPeriods()
	 * .remove(loan.getPeriod());
	 * 
	 * return list; }
	 */

	/**
	 * Returns a string representation of the manager and its values.
	 */
	@Override
	public String toString() {
		return "Manager: " + super.toString();
	}
}
