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
import config.Model;
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

	public void accept(Loan loan) {
		loan.setAccepted(true);
	}

	// Methods

	/**
	 * Checks if the loan is valid.
	 * 
	 * @param l
	 * 
	 * @param i
	 * 
	 * @return true if it is, false otherwise
	 */
	public boolean checkLoan(Loan l, ManagementSystem ms) {
		Borrower bwer = l.getBorrower();
		Period period = l.getPeriod();
		HashMap<Model, ArrayList<Equipment>> askedStuff = l.getStuff();
		if (bwer == null || period == null || askedStuff == null
				|| askedStuff.isEmpty())
			throw new IllegalArgumentException("null argument fields");

		if (!checkBorrower(bwer, period)) {
			l.setAccepted(false);
			// TODO call of a method altering the loan to satisfy these
			// standards
		}
		if (!checkModels(askedStuff, period)) {
			l.setAccepted(false);
			// TODO call of a method altering the loan to satisfy these
			// standards
		}
		if (!checkEquipments(askedStuff, period, ms)) {
			l.setAccepted(false);
			// TODO call of a method altering the loan to satisfy these
			// standards
		}
	}

	/**
	 * Checks if the given borrower can borrow during the given period.
	 * 
	 * @param b
	 *            the borrower to check rights
	 * @param p
	 *            the period to verify
	 * @return true if he can, false otherwise
	 */
	private boolean checkBorrower(Borrower b, Period p) {
		int duration_limit;
		int reservation_limit;

		if (b.getType().equals("teacher")) {
			duration_limit = TEACHER_LOAN_DURATION_LIMIT;
			reservation_limit = TEACHER_LOAN_RESERVATION_LIMIT;
		} else {
			duration_limit = STUDENT_LOAN_DURATION_LIMIT;
			reservation_limit = STUDENT_LOAN_RESERVATION_LIMIT;
		}
		if (p.getDuration() > duration_limit
				|| p.daysFromNow() > reservation_limit)
			return false;
		return true;
	}

	/**
	 * Checks if the given HashMap of models associated to ArrayLists of
	 * equipments verify the models borrow constraints in relation to the given
	 * period.
	 * 
	 * @param hm
	 *            the HashMap to check
	 * @param p
	 *            the period to verify
	 * @return true if the conditions are checked, false otherwise
	 */
	private boolean checkModels(HashMap<Model, ArrayList<Equipment>> hm,
			Period p) {
		Model model;
		Set<Model> sm = hm.keySet();
		Iterator<Model> it = sm.iterator();

		while (it.hasNext()) {
			model = it.next();
			if (p.getDuration() > model.getLoanDurationLimit()
					|| model.getLoanQuantityLimit() > hm.get(model).size()) // ne marche pas
				return false;
		}
		return true;
	}

	private boolean checkEquipments(HashMap<Model, ArrayList<Equipment>> hm, Period p, ManagementSystem ms) {
		Model model;
		Set<Model> sm = hm.keySet();
		Iterator<Model> it = sm.iterator();
		
		while(it.hasNext()) {
			model = it.next();
			for(Equipment e: hm.get(model))
				if(!ms.)
		}
	}

	/**
	 * Sets the given limits according to the given borrower's type.
	 * 
	 * @param bwer
	 *            the borrower according to which the limits have to be set
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
