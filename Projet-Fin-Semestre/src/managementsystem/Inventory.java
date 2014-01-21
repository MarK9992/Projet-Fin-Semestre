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
 * Inventory class, contains references to all equipments of the system. Allows
 * access on them.
 * 
 * @author Marc Karassev, Anaïs Marongiu
 * 
 */
public class Inventory {
	// TODO java documentation
	// TODO extends HashMap instead of using a HashMap field ?
	// TODO loanLists instead of using unavailabalityPeriods fields of Equipment
	// ?
	// TODO tests

	private HashMap<Model, ArrayList<Equipment>> inventory = new HashMap<Model, ArrayList<Equipment>>();

	/**
	 * Default constructor.
	 */
	public Inventory() {
		this.inventory.put(Model.VENGEANCE2100, new ArrayList<Equipment>());
		this.inventory.put(Model.XPERIAZ, new ArrayList<Equipment>());
		this.inventory.put(Model.IPAD3, new ArrayList<Equipment>());
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
	 * Constructor with HashMap
	 * 
	 * @param inventory
	 */
	public Inventory(HashMap<Model, ArrayList<Equipment>> inventory) {
		this.inventory = inventory;
	}

	// Getters
	public HashMap<Model, ArrayList<Equipment>> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap<Model, ArrayList<Equipment>> inventory) {
		this.inventory = inventory;
	}

	// Methods

	/**
	 * Add an equipment in the stock
	 * 
	 * @param e
	 */
	public void addEquipment(Equipment e) {
		this.inventory.get(e.getType()).add(e);
	}

	/**
	 * Remove an equipment from the stock
	 * 
	 * @param e
	 */
	public void removeEquipment(Equipment e) {
		this.inventory.get(e.getType()).remove(e);
	}

	/**
	 * Looks for the equipment of the ID id.
	 * 
	 * @param id
	 * @return the equipment, null if not found.
	 */
	public Equipment findEquipmentByID(String id) {
		Equipment eq;
		// TODO use of a method like Model#getAll() or like in
		// getNumberElements()
		Model[] t = { Model.IPAD3, Model.VENGEANCE2100, Model.XPERIAZ,
				Model.UNKWOWN };

		for (int j = 0; j < t.length; j++) {
			for (int i = 0; i < this.inventory.get(t[j]).size(); i++) {
				eq = this.inventory.get(t[j]).get(i);
				if (eq.getId().equals(id))
					return eq;
			}
		}

		return null;
	}

	/**
	 * Looks for an equipment available now.
	 * 
	 * @return the equipment or null if none found.
	 */
	public Equipment findAvailableEquipment() {
		Equipment eq;
		// TODO use of a method like Model#getAll() or like in
		// getNumberElements()
		Model[] t = { Model.IPAD3, Model.VENGEANCE2100, Model.XPERIAZ,
				Model.UNKWOWN };

		for (int j = 0; j < t.length; j++) {
			for (int i = 0; i < this.inventory.get(t[j]).size(); i++) {
				eq = this.inventory.get(t[j]).get(i);
				if (eq.availableNow())
					return eq;
			}
		}

		return null;
	}

	/**
	 * Looks for an equipment of model m available now.
	 * 
	 * @param m
	 * @return the equipment or null if none found.
	 */
	public Equipment findAvailableEquipment(Model m) {
		Equipment eq;

		for (int i = 0; i < this.inventory.get(m).size(); i++) {
			eq = this.inventory.get(m).get(i);
			if (eq.availableNow())
				return eq;
		}

		return null;
	}

	/**
	 * Looks for an equipment of model m available during the period p.
	 * 
	 * @param m
	 * @param p
	 * @return the equipment or null if none found
	 */
	public Equipment findAvailableEquipmentAt(Model m, Period p) {
		Equipment eq;

		for (int i = 0; i < this.inventory.get(m).size(); i++) {
			eq = this.inventory.get(m).get(i);
			if (eq.availableAt(p))
				return eq;
		}

		return null;
	}

	/**
	 * Counts the total number of elements in the stock
	 * 
	 * @return the number of Elements in the inventory.
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
	 * Checks if the equipment e exists in the stock
	 * 
	 * @param e
	 * @return true if yes, false else
	 */
	public Boolean isInStock(Equipment e) {
		Set<Model> keys = this.inventory.keySet();
		Iterator<Model> it = keys.iterator();

		while (it.hasNext()) {
			Model key = it.next();

			for (Equipment i : this.inventory.get(key)) {
				if (e.equals(i))
					return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String res = "";
		Set<Model> keys = this.inventory.keySet();
		Iterator<Model> it = keys.iterator();

		res += "--- EQUIPMENTS ---\n\n";

		while (it.hasNext()) {
			Model key = it.next();
			res += "EQUIPMENTS TYPE : " + key.toString() + "\n";

			for (Equipment e : this.inventory.get(key)) {
				res += "\t" + e.toString() + "\n";
			}
		}
		return res;
	}
}
