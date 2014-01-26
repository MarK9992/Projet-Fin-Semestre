package users;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import utils.Period;

import managementsystem.Ask;
import managementsystem.Loan;
import managementsystem.ManagementSystem;
import config.BorrowerConstants;
import config.Model;
import config.Models;
import equipment.Equipment;

/**
 * Manager class, a user who can manage the inventory and validate or refuse
 * loans. He also controls the state of loans.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev, Anthony Saraïs
 * 
 * @author Marc Karassev, Anthony Saraïs
 * 
 */
public class Manager extends User implements BorrowerConstants, Serializable {
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
	 * Adds a model the management system's set of models.
	 * 
	 * @param m
	 *            the model to add
	 */
	public void addModel(Model m) {
		ManagementSystem.getManagementSystem().getModels().add(m);
	}

	/**
	 * Removes a model from the management system's set of models.
	 * 
	 * @param m
	 *            the model to remove
	 */
	public void removeModel(Model m) {
		ManagementSystem.getManagementSystem().getModels().remove(m);
	}

	/**
	 * Accepts an ask and creates the corresponding loan. The ask is removed
	 * from the management system's ask list and the loan is added to its loan
	 * list.
	 * 
	 * @param ask
	 *            the ask to accept
	 * @throws IOException
	 * @throws NullPointerException
	 *             when there's not enough equipment available to create the
	 *             loan
	 */
	public void acceptAsk(Ask ask) throws IOException, NullPointerException {
		Loan loan = new Loan(ask);
		Set<Model> keys = ask.getAskedStuff().keySet();
		Iterator<Model> it = keys.iterator();
		Model key;

		ManagementSystem.getManagementSystem().addLoan(loan);
		while (it.hasNext()) {
			key = it.next();
			for (int i = 0; i < ask.getAskedStuff().get(key); i++) {
				System.out
						.println("test: "
								+ ManagementSystem.getManagementSystem()
										.findAvailableEquipmentAt(key,
												ask.getPeriod()));
				loan.addEquipment(ManagementSystem.getManagementSystem()
						.findAvailableEquipmentAt(key, ask.getPeriod()));
			}
		}
		ManagementSystem.getManagementSystem().removeAsk(ask);
	}

	/**
	 * Checks automatically all the asks of the management system.
	 * 
	 * @return an HashMap<Ask, String> where keys are the asks and value a
	 *         string describing the result of its validity checking.
	 */
	public HashMap<Ask, String> checkAsks() {
		HashMap<Ask, String> hm = new HashMap<Ask, String>();

		for (Ask a : ManagementSystem.getManagementSystem().getAsks()) {
			hm.put(a, checkAsk(a));
		}
		return hm;
	}

	/**
	 * Checks an ask by successively checking all error possibilities.
	 * 
	 * @param a
	 *            the ask to check
	 * @return a string description of the result of the ask validity checking
	 */
	public String checkAsk(Ask a) {
		Borrower bwer = a.getBorrower();
		Period period = a.getPeriod();
		HashMap<Model, Integer> askedStuff = a.getAskedStuff();

		if (bwer == null || period == null || askedStuff == null
				|| askedStuff.isEmpty())
			throw new IllegalArgumentException("null argument fields");

		if (!checkBorrower(bwer, period)) {
			return "Invalid borrower rights for the asked period.";
			// TODO call of a method altering the loan to satisfy these
			// standards
		}
		if (!checkModels(askedStuff, period)) {
			return "Invalid ask for asked models.";
			// TODO call of a method altering the loan to satisfy these
			// standards
		}
		if (!checkEquipments(askedStuff, period)) {
			return "Some are equipments unavailable.";
			// TODO call of a method altering the loan to satisfy these
			// standards
		}
		return "OK";
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
	private boolean checkModels(HashMap<Model, Integer> hm, Period p) {
		Model model;
		Set<Model> sm = hm.keySet();
		Iterator<Model> it = sm.iterator();

		while (it.hasNext()) {
			model = it.next();
			if (p.getDuration() > model.getLoanDurationLimit()
					|| model.getLoanQuantityLimit() > hm.get(model))
				return false;
		}
		return true;
	}

	/**
	 * Checks if there is enough available equipments during the given period.
	 * 
	 * @param hm
	 *            the HashMap<Model, Integer> describing the number of models
	 *            needed
	 * @param p
	 *            the period to verify
	 * @return true if there is enough available equipments, false otherwise
	 */
	private boolean checkEquipments(HashMap<Model, Integer> hm, Period p) {
		Model model;
		Set<Model> sm = hm.keySet();
		Iterator<Model> it = sm.iterator();

		while (it.hasNext()) {
			model = it.next();
			for (int i = 0; i < hm.get(model); i++)
				if (ManagementSystem.getManagementSystem()
						.findNAvailableEquipmentAt(model, hm.get(model), p) == null)
					return false;
		}
		return true;
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
