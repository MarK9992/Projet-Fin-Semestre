package managementsystem;

import java.util.HashMap;

import users.Borrower;
import utils.Period;

import config.Model;

public class Ask {

	// Fields

	private HashMap<Model, Integer> askedStuff;
	private Period period;
	private Borrower borrower;

	// Constructors

	public Ask() {
		this(new HashMap<Model, Integer>(), new Period(), new Borrower());
	}

	public Ask(HashMap<Model, Integer> aS, Period p, Borrower b) {
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
