package managementsystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.Serializable;

import users.Borrower;
import utils.Period;

import config.Model;
import config.Models;

public class Ask implements Serializable {

	// Fields

	private HashMap<Model, Integer> askedStuff;
	private Period period;
	private Borrower borrower;

	// Constructors

	public Ask() {
		this(new HashMap<Model, Integer>(), new Period(), new Borrower());
	}

	public Ask(HashMap<Model, Integer> aS, Period p, Borrower b) {
		Set<Model> keys = aS.keySet();
		Iterator<Model> it = keys.iterator();
		Model model;
		
		while(it.hasNext()) {
			model = it.next();
			Models.containsModel(model);
		}
		askedStuff = aS;
		period = p;
		borrower = b;
	}

	// Methods

	public String toString() {
		return "Asked stuff: " + askedStuff + ", period: " + period
				+ ", borrower: " + borrower;
	}
	
	// Getters and setters
	
	public HashMap<Model, Integer> getAskedStuff() {
		return askedStuff;
	}
	
	public Period getPeriod() {
		return period;
	}
	
	public Borrower getBorrower() {
		return borrower;
	}
}
