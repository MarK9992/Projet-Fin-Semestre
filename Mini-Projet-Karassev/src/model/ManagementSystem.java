package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.users.Manager;
import model.users.Student;
import model.users.Teacher;
import model.users.User;
import config.ConfigXML;

/**
 * Contains all the information about the management system and the methods to
 * run it.
 * 
 * @author Anaïs
 * 
 */
public class ManagementSystem {
    private Inventory inventory;
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Manager> managers = new ArrayList<Manager>();
    private ArrayList<Loan> ongoingValidationLoans = new ArrayList<Loan>();

    public ManagementSystem(String configInventoryFile, String configUsersFile,
            String configVersion) {
        this.inventory = new Inventory(configInventoryFile, configVersion);
        this.students = ((HashMap<String, ArrayList<Student>>) ConfigXML.load(
                configUsersFile, configVersion)).get("students");
        this.teachers = ((HashMap<String, ArrayList<Teacher>>) ConfigXML.load(
                configUsersFile, configVersion)).get("teachers");
        this.managers = ((HashMap<String, ArrayList<Manager>>) ConfigXML.load(
                configUsersFile, configVersion)).get("managers");

    }

    /**
     * Calls a manager to check a loan.
     * 
     * @param l
     */
    public void checkLoan(Loan l) {
        Manager m = new Manager();
        m = (Manager) (this.managers.get(0));
        if (m.checkLoan(l, this.inventory) == true) {
            ongoingValidationLoans.add(l);
        }
    }

    /**
     * Calls a manager to give back a loan.
     * 
     * @param l
     */
    public void putAway(Loan l) {
        Manager m = new Manager();
        m = (Manager) (this.managers.get(0));
        this.ongoingValidationLoans = m.putAway(l, this.ongoingValidationLoans,
                this.inventory);
    }

    // Getters and setters

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<Manager> managers) {
        this.managers = managers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Loan> getOngoingValidationLoans() {
        return ongoingValidationLoans;
    }

    public void setOngoingValidationLoans(ArrayList<Loan> ongoingValidationLoans) {
        this.ongoingValidationLoans = ongoingValidationLoans;
    }

    @Override
    public String toString() {
        String res = "";

        res += this.inventory.toString();
        res += "\n\n";
        res += "--- USERS ---\n";

        res += "\nManagers\n";
        for (User u : this.managers) {
            res += "\t" + u.toString() + "\n";
        }

        res += "\nStudents\n";
        for (User u : this.students) {
            res += "\t" + u.toString() + "\n";
        }

        res += "\nTeachers\n";
        for (User u : this.teachers) {
            res += "\t" + u.toString() + "\n";
        }

        res += "\n--- VALIDATION LOANS ---\n\n";
        for (Loan l : this.ongoingValidationLoans) {
            res += "\t" + l.toString() + "\n";
        }

        return res;
    }

    public String toStringLoan() {
        String res = "";

        res += "--- USERS ---\n";

        res += "\n--- VALIDATION LOANS ---\n\n";
        for (Loan l : this.ongoingValidationLoans) {
            res += "\t" + l.toString() + "\n";
        }

        return res;
    }
}
