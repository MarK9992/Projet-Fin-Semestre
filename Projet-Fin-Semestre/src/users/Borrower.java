package users;

import java.util.ArrayList;

import managementsystem.Loan;
import utils.Period;
import config.Model;

/**
 * Super class Borrower, defines all common properties to borrowers.
 * 
 * @author Marc Karassev
 * 
 */
public class Borrower extends User {
	// TODO java doc
	// TODO check use of the field loanList and re-factor the class if necessary
	// TODO tests

    // Fields

    private ArrayList<Loan> loanList = new ArrayList<Loan>();
    private final String type;

    // Constructors

    public Borrower() {
        this("B", "unknown", new ArrayList<Loan>(), "unknown");
    }

    public Borrower(String i, String n, ArrayList<Loan> l, String t) {
        super(i, n);

        this.loanList = l;
        type = t;
    }

    // Methods

    /**
     * Asks for an equipment of model m in a reservation.
     * 
     * @param m
     * @param p
     * @return the Loan instance created
     */
    public Loan book(Model m, Period p) {
        Loan l = new Loan(m, p, this);
        
        return l;
	}

    /*/**
     * Gives back the equipment borrowed in Loan l.
     * 
     * @param l
     */
    // TODO public void giveBack(Loan l);

    public String toString() {
        return super.toString() + ", loan list: " + loanList;
    }

    // Getters and setters
    public void setLoanList(ArrayList<Loan> loanList) {
        this.loanList = loanList;
    }

    public ArrayList<Loan> getLoanList() {
        return loanList;
    }

    public String getType() {
        return type;
    }
}
