package model.users;

import java.util.ArrayList;

import model.Inventory;
import model.Loan;
import model.equipment.Equipment;
import utils.Period;
import config.BorrowerConstants;

/**
 * Manager class, a user with specific methods.
 * 
 * @author Marc
 * 
 */
public class Manager extends User implements BorrowerConstants {

    // Constructors

    public Manager() {
        this("M", "unknown");
    }

    public Manager(String i, String n) {
        super(i, n);
    }

    // Methods

    /**
     * Checks if the loan is valid.
     * 
     * @param l
     * @param i
     * @return true if it is, false otherwise
     */
    public boolean checkLoan(Loan l, final Inventory i) {
        Borrower bwer = l.getBorrower();
        Period period = l.getPeriod();
        Equipment stuff = i.findAvailableEquipment(l.getModel());
        final int LOAN_DURATION_LIMIT;
        final int LOAN_RESERVATION_LIMIT;

        // Checks if the loan is valid
        if (stuff == null)
            return false;

        // if(bwer.getType().equals("teacher")) => ne reconnait pas que c'est un
        // Teacher
        if (bwer instanceof Teacher) {
            LOAN_DURATION_LIMIT = TEACHER_LOAN_DURATION_LIMIT;
            LOAN_RESERVATION_LIMIT = TEACHER_LOAN_RESERVATION_LIMIT;
        } else {
            LOAN_DURATION_LIMIT = STUDENT_LOAN_DURATION_LIMIT;
            LOAN_RESERVATION_LIMIT = STUDENT_LOAN_RESERVATION_LIMIT;
        }
        if (period.getDuration() > LOAN_DURATION_LIMIT
                || period.daysFromNow() > LOAN_RESERVATION_LIMIT)
            return false;

        // Updates the stuff, the loan and the borrower
        stuff.getUnavailabalityPeriods().add(period);
        l.setEquipmentID(stuff.getId());

        bwer.getLoanList().add(l);
        return true;
    }

    /**
     * Puts away a loan, updates references of the loanList, and the equipment
     * concerned.
     * 
     * @param loan
     * @param list
     * @param i
     *            inventory where the equipment concerned by the loan is
     *            referenced
     * @return the loan list updated
     */
    public ArrayList<Loan> putAway(Loan loan, ArrayList<Loan> list, Inventory i) {
        list.remove(loan);
        loan.getBorrower().getLoanList().remove(loan);
        i.findEquipmentByID(loan.getEquipmentID()).getUnavailabalityPeriods()
                .remove(loan.getPeriod());

        return list;
    }
}
