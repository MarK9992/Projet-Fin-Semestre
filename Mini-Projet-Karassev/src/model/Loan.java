package model;

import model.users.Borrower;
import utils.Period;
import config.Model;

/**
 * Loan class, contains all informations about a loan.
 * 
 * @author Marc
 * 
 */
public class Loan {

    // Fields

    private Model model;
    private String equipmentID;
    private Period period;
    private Borrower borrower;

    // Constructors

    /**
     * Default constructor, unused.
     */
    public Loan() {
        this(null, new Period(), null);
    }

    /**
     * Constructor used to make a reservation of a model.
     * @param model
     * @param p
     * @param borrower
     */
    public Loan(Model model, Period p, Borrower borrower) {
        this.model = model;
        this.period = p;
        this.borrower = borrower;
    }

    // Methods

    public String toString() {
        return "EquipmentID: " + equipmentID + ", model: " + model
                + ", period: " + period;
    }

    // Getters and setters

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String s) {
        equipmentID = s;
    }

    public Model getModel() {
        return model;
    }

    public Period getPeriod() {
        return period;
    }

    public Borrower getBorrower() {
        return borrower;
    }
}
