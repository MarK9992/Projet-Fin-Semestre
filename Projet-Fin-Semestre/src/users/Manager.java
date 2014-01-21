package users;

import java.util.ArrayList;

import managementsystem.Inventory;
import managementsystem.Loan;
import equipment.Equipment;
import utils.Period;
import config.BorrowerConstants;

/**
 * Manager class, a user who can manage the inventory and validate or refuse
 * loans. He also controls the state of loans.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public class Manager extends User implements BorrowerConstants {
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

	/*
	 * TODO update in relation to the new HashMap field of class Loan. /**
	 * Checks if the loan is valid.
	 * 
	 * @param l
	 * 
	 * @param i
	 * 
	 * @return true if it is, false otherwise
	 */
	/*
	 * public boolean checkLoan(Loan l, Inventory i) { Borrower bwer =
	 * l.getBorrower(); Period period = l.getPeriod(); Equipment stuff =
	 * i.findAvailableEquipment(l.getModel()); final int LOAN_DURATION_LIMIT;
	 * final int LOAN_RESERVATION_LIMIT;
	 * 
	 * // Checks if the loan is valid if (stuff == null) return false;
	 * 
	 * // Defines the constants to use if (bwer.getType().equals("teacher")) {
	 * LOAN_DURATION_LIMIT = TEACHER_LOAN_DURATION_LIMIT; LOAN_RESERVATION_LIMIT
	 * = TEACHER_LOAN_RESERVATION_LIMIT; } else { LOAN_DURATION_LIMIT =
	 * STUDENT_LOAN_DURATION_LIMIT; LOAN_RESERVATION_LIMIT =
	 * STUDENT_LOAN_RESERVATION_LIMIT; } if (period.getDuration() >
	 * LOAN_DURATION_LIMIT || period.daysFromNow() > LOAN_RESERVATION_LIMIT)
	 * return false;
	 * 
	 * // Updates the stuff, the loan and the borrower
	 * stuff.getUnavailabalityPeriods().add(period);
	 * l.setEquipmentID(stuff.getId());
	 * 
	 * return true; }
	 */

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
}
