package managementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import equipment.Equipment;
import utils.Period;
//import config.ConfigXML;
import config.Model;

/**
 * ManagementSystem class, contains references to all equipments of the system
 * and to all loans. Allows access on both of them by the use of search methods.
 * Fields are an ArrayList of loans and a HashMaps where keys are config.Model
 * constants and values are ArrayLists of equipment matching the model.
 * 
 * initial code by: Anaïs Marongiu, Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev, Anaïs Marongiu
 * 
 */
public class ManagementSystem {
	// TODO tests

	private ArrayList<Loan> loans;
	private HashMap<Model, ArrayList<Equipment>> inventory;

	/**
	 * Default constructor, constructs a new ManagementSystem with empty
	 * ArrayLists for the loans and the inventory.
	 */
	public ManagementSystem() {
		loans = new ArrayList<Loan>();
		inventory = new HashMap<Model, ArrayList<Equipment>>();
		for (Model m : Model.values())
			inventory.put(m, new ArrayList<Equipment>());
	}

	/*
	 * /** TODO Constructor with configuration.
	 * 
	 * @param defaultConfigNameFile
	 * 
	 * @param defaultConfigVersion
	 */
	/*
	 * public Inventory(String defaultConfigNameFile, String
	 * defaultConfigVersion) { this.inventory = (HashMap<Model,
	 * ArrayList<Equipment>>) ConfigXML.load( defaultConfigNameFile,
	 * defaultConfigVersion); }
	 */

	/**
	 * Constructs a new ManagementSystem with the specified ArrayList for the
	 * loans field and the specified HashMap inventory field.
	 * 
	 * @param inventory
	 *            the HashMap used to set the inventory field
	 * @param loans
	 *            the ArrayList used to set the loans field
	 */
	public ManagementSystem(HashMap<Model, ArrayList<Equipment>> inventory,
			ArrayList<Loan> loans) {
		this.inventory = inventory;
		this.loans = loans;
		for (Model m : Model.values())
			inventory.put(m, new ArrayList<Equipment>());
	}

	// Methods

	/**
	 * Adds an equipment in the inventory.
	 * 
	 * @param the
	 *            equipment to add
	 */
	public void addEquipment(Equipment e) {
		this.inventory.get(e.getType()).add(e);
	}

	/**
	 * Removes an equipment from the stock
	 * 
	 * @param the
	 *            equipment to remove
	 */
	public void removeEquipment(Equipment e) {
		this.inventory.get(e.getType()).remove(e);
	}

	/**
	 * Says if the given equipment is available now by checking if it is related
	 * to any loan. If it is, checks if today is in the period corresponding to
	 * the loan.
	 * 
	 * @param e
	 *            the equipment to check its availability
	 * @return true if the equipment is available now, false otherwise
	 */
	private boolean equipmentAvailableNow(Equipment e) {
		for (Loan l : loans)
			for (Equipment eq : l.getStuff().get(e.getType()))
				if (eq.equals(e) && l.getPeriod().today())
					return false;
		return true;
	}

	/**
	 * Says if the given equipment is available during the given period by
	 * checking if the equipment is related to any loan. If it is, checks if the
	 * given period is overlapping with the one corresponding to the loan.
	 * 
	 * @param e
	 *            the equipment to check its availability
	 * @param p
	 *            the period during which the availability has to be checked
	 * @return
	 */
	private boolean equipmentAvailableAt(Equipment e, Period p) {
		for (Loan l : loans)
			for (Equipment eq : l.getStuff().get(e.getType()))
				if (eq.equals(e) && Period.overlap(l.getPeriod(), p))
					return false;
		return true;
	}

	/**
	 * Looks for the equipment of the specified ID.
	 * 
	 * @param id
	 *            the ID to look for
	 * @return the equipment, null if not found.
	 */
	public Equipment findEquipmentById(String id) {
		Set<Model> keys = this.inventory.keySet();
		Iterator<Model> it = keys.iterator();
		Model key;

		// TODO search depending on IDs ?
		while (it.hasNext()) {
			key = it.next();
			for (Equipment eq : inventory.get(key))
				if (eq.getId().equals(id))
					return eq;
		}
		return null;
	}

	/**
	 * Looks for an equipment available now.
	 * 
	 * @return a matching equipment or null if none found.
	 */
	public Equipment findAvailableEquipment() {
		Set<Model> keys = this.inventory.keySet();
		Iterator<Model> it = keys.iterator();
		Model key;

		while (it.hasNext()) {
			key = it.next();
			for (Equipment eq : inventory.get(key))
				if (equipmentAvailableNow(eq))
					return eq;
		}
		return null;
	}

	/**
	 * Looks for an equipment of model m available now.
	 * 
	 * @param m
	 *            the model of equipment to look for
	 * @return a matching equipment or null if none found.
	 */
	public Equipment findAvailableEquipment(Model m) {
		for (Equipment eq : inventory.get(m))
			if (equipmentAvailableNow(eq))
				return eq;
		return null;
	}

	/**
	 * Looks for an equipment available during the period p.
	 * 
	 * @param p
	 *            the period during which the equipment has to be available
	 * @return a matching equipment or null if none found
	 */
	public Equipment findAvailableEquipmentAt(Period p) {
		Set<Model> keys = this.inventory.keySet();
		Iterator<Model> it = keys.iterator();
		Model key;

		while (it.hasNext()) {
			key = it.next();
			for (Equipment eq : inventory.get(key))
				if (equipmentAvailableAt(eq, p))
					return eq;
		}
		return null;
	}

	/**
	 * Looks for an equipment of model m available during the period p.
	 * 
	 * @param m
	 *            the model of equipment to look for
	 * @param p
	 *            the period during which the equipment has to be available
	 * @return a matching equipment or null if none found
	 */
	public Equipment findAvailableEquipmentAt(Model m, Period p) {
		for (Equipment eq : inventory.get(m))
			if (equipmentAvailableAt(eq, p))
				return eq;
		return null;
	}

	/**
	 * Counts the total number of elements in the stock.
	 * 
	 * @return the number of equipments in the inventory
	 */
	public int getNumberElements() {
		int number = 0;
		Set<Model> keys = this.inventory.keySet();
		Iterator<Model> it = keys.iterator();

		while (it.hasNext()) {
			Model key = it.next();
			number += this.inventory.get(key).size();
		}
		return number;
	}

	/**
	 * Checks if the inventory contains the given equipment.
	 * 
	 * @param e
	 *            the equipment to look for in the inventory
	 * @return true if it is, false otherwise
	 */
	public Boolean contains(Equipment e) {
		if (findEquipmentById(e.getId()) != null)
			return true;
		return false;
	}

	/**
	 * Returns a string representation of the management system and its values.
	 */
	@Override
	public String toString() {
		return loans + "\n" + inventory;
	}

	// Getters and setters

	/**
	 * Returns the management system's inventory HashMap.
	 * 
	 * @return the value of the HashMap field inventory;
	 */
	public HashMap<Model, ArrayList<Equipment>> getInventory() {
		return inventory;
	}

	/**
	 * Sets the value of the HashMap field inventory with the given HashMap.
	 * 
	 * @param inventory
	 *            the new inventory value
	 */
	public void setInventory(HashMap<Model, ArrayList<Equipment>> inventory) {
		this.inventory = inventory;
	}

	/**
	 * Returns the management system's loans ArrayList.
	 * 
	 * @return the value of the ArrayList field loans.
	 */
	public ArrayList<Loan> getLoans() {
		return loans;
	}

	/**
	 * Sets the value of the ArrayList field loans with the given ArrayList.
	 * 
	 * @param loans
	 *            the new loans value
	 */
	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}
}
