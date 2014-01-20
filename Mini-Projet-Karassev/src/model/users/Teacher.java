package model.users;

import java.util.ArrayList;

import model.Loan;
import utils.Period;
import config.Model;

/**
 * Class Teacher, is a borrower with its own implementation.
 * 
 * @author Marc
 * 
 */
public class Teacher extends Borrower {

    // Constructors

    public Teacher() {
        this("T", "unknown", new ArrayList<Loan>());
    }

    public Teacher(String i, String n, ArrayList<Loan> l) {
        super(i, n, l, "teacher");
    }

    // Methods

    /**
     * Asks for an equipment of model m in a reservation.
     * 
     * @param m
     * @param p
     * @return the Loan instance created
     */
    @Override
    public Loan book(Model m, Period p) {
        Loan l = new Loan(m, p, this);

        return l;
    }

    /*/**
     * Gives back the equipment borrowed in Loan l.
     * 
     * @param l
     */
    /*@Override
    public void giveBack(Loan l) {
        // TODO Auto-generated method stub

    }*/
}
