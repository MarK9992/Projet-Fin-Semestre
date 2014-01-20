package view;

import model.Loan;
import model.ManagementSystem;
import model.users.User;

/**
 * This class contains all the outputs.
 * 
 * @author Anaïs
 * 
 */
public class View {

    /**
     * Displays the menu.
     */
    public void displayMenu() {
        System.out
                .println("***** Welcome to the equipment management system *****\n");
        System.out.println("This is the state of the system:\n");
    }

    /**
     * Displays the ManagementSystem s.
     * 
     * @param s
     */
    public void displaySystem(ManagementSystem s) {
        System.out.println("\n" + s.toString());
    }

    /**
     * Displays the Loan l made by the User u.
     * 
     * @param u
     * @param l
     */
    public void displayBorrow(User u, Loan l) {
        System.out.println("\n" + u.toString());
        System.out.println("borrows:");
        System.out.println(l.toString());
    }

    /**
     * Displays the return of the Loan l made by the User u.
     * 
     * @param u
     * @param l
     */
    public void displayReturn(User u, Loan l) {
        System.out.println("\n" + u.toString());
        System.out.println("gives back:");
        System.out.println(l.toString());
    }

    /**
     * Displays the example message.
     */
    public void displayExampleMessage() {
        System.out.println("This is an example of borrowing and a returning:");

    }
}
