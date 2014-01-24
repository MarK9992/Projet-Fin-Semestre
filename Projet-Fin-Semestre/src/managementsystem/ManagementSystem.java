package managementsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import equipment.Equipment;
import users.Borrower;
import users.User;
import utils.Period;
import utils.StoreLoad;
//import config.ConfigXML;
import config.Model;
import config.Models;

/**
 * ManagementSystem class, contains references to all equipments of the system,
 * to all loans and to all users. Allows access on all of them by the use of
 * search methods. Fields are an ArrayList of loans, an ArrayLists of users and
 * a HashMaps where keys are Model instances and values are ArrayLists of
 * equipment matching the model.
 * 
 * initial code by: Anaïs Marongiu, Marc Karassev; modified by: Marc Karassev,
 * Hugo Simond
 * 
 * @author Marc Karassev, Hugo Simond, Anaïs Marongiu
 * 
 */
public class ManagementSystem {
    // TODO tests

    private ArrayList<Loan> loans;
    private ArrayList<Ask> asks;
    private HashMap<Model, ArrayList<Equipment>> inventory;
    private ArrayList<User> users;

    /**
     * Default constructor, constructs a new ManagementSystem with empty
     * ArrayLists for the loans and the inventory. However if the file "stock"
     * exist and isn't empty, loads him.
     */
    public ManagementSystem() {
        Iterator<Model> it = Models.getModels().iterator();
        Model key;
        StoreLoad seria = new StoreLoad();

        inventory = new HashMap<Model, ArrayList<Equipment>>();
        loans = new ArrayList<Loan>();
        users = new ArrayList<User>();
        asks = new ArrayList<Ask>();

        try {
            inventory = (HashMap<Model, ArrayList<Equipment>>) seria
                    .Input("Stock");
            asks = (ArrayList<Ask>) seria.Input("Asks");
            loans = (ArrayList<Loan>) seria.Input("Loans");
            users = (ArrayList<User>) seria.Input("Users");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out
                    .println("Un des fichiers est manquant. Creation ...");
            while (it.hasNext()) {
                key = it.next();
                inventory.put(key, new ArrayList<Equipment>());
            }
        }
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
     * loans field and the specified HashMap inventory field. However if the
     * file "stock" exist and isn't empty, load him.
     * 
     * @param inventory
     *            the HashMap used to set the inventory field
     * @param loans
     *            the ArrayList used to set the loans field
     */
    public ManagementSystem(HashMap<Model, ArrayList<Equipment>> inventory,
            ArrayList<Loan> loans) {
        Iterator<Model> it = Models.getModels().iterator();
        Model key;
        StoreLoad seria = new StoreLoad();

        this.inventory = inventory;
        this.loans = loans;

        try {
            inventory = (HashMap<Model, ArrayList<Equipment>>) seria
                    .Input("Stock");
            asks = (ArrayList<Ask>) seria.Input("Asks");
            loans = (ArrayList<Loan>) seria.Input("Loans");
            users = (ArrayList<User>) seria.Input("Users");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out
                    .println("Un des fichiers est manquant. Creation ...");
            while (it.hasNext()) {
                key = it.next();
                Models.containsModel(key);
                inventory.put(key, new ArrayList<Equipment>());
            }
        }
    }

    // Methods

    // Add/Remove Methods

    /**
     * Adds an equipment in the inventory.
     * 
     * @param e
     *            the equipment to add
     * @throws IOException
     */
    public void addEquipment(Equipment e) throws IOException {
        this.inventory.get(e.getModel()).add(e);
        StoreLoad seria = new StoreLoad();
        seria.Output(this.inventory, "Stock");
    }

    /**
     * Removes an equipment from the inventory.
     * 
     * @param e
     *            the equipment to remove
     * @throws IOException
     */
    public void removeEquipment(Equipment e) throws IOException {
        this.inventory.get(e.getModel()).remove(e);
        StoreLoad seria = new StoreLoad();
        seria.Output(this.inventory, "Stock");
    }

    /**
     * Adds a loan to the loan list.
     * 
     * @param l
     *            the loan to add
     * @throws IOException
     */
    public void addLoan(Loan l) throws IOException {
        loans.add(l);
        StoreLoad seria = new StoreLoad();
        seria.Output(this.loans, "Loans");
    }

    /**
     * Removes a loan from the loan list.
     * 
     * @param l
     *            the loan to remove
     * @throws IOException
     */
    public void removeLoan(Loan l) throws IOException {
        loans.remove(l);
        StoreLoad seria = new StoreLoad();
        seria.Output(this.loans, "Loans");
    }

    /**
     * Adds a user to the loan list.
     * 
     * @param u
     *            the user to add
     * @throws IOException
     */
    public void addUser(User u) throws IOException {
        users.add(u);
        StoreLoad seria = new StoreLoad();
        seria.Output(this.users, "Users");
    }

    /**
     * Removes a user from the loan list.
     * 
     * @param u
     *            the user to remove
     * @throws IOException
     */
    public void removeUser(User u) throws IOException {
        users.remove(u);
        StoreLoad seria = new StoreLoad();
        seria.Output(this.users, "Users");
    }

    public void addAsk(Ask a) throws IOException {
        asks.add(a);
        StoreLoad seria = new StoreLoad();
        seria.Output(this.asks, "Asks");
    }

    public void removeAsk(Ask a) throws IOException {
        asks.remove(a);
        StoreLoad seria = new StoreLoad();
        seria.Output(this.asks, "Asks");
    }

    // Equipment availability methods

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
            for (Equipment eq : l.getStuff().get(e.getModel()))
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
            for (Equipment eq : l.getStuff().get(e.getModel()))
                if (eq.equals(e) && Period.overlap(l.getPeriod(), p))
                    return false;
        return true;
    }

    // Equipment search methods

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
        Models.containsModel(m);
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
        Models.containsModel(m);
        for (Equipment eq : inventory.get(m))
            if (equipmentAvailableAt(eq, p))
                return eq;
        return null;
    }

    public ArrayList<Equipment> findNAvailableEquipmentAt(Model m, int n, Period p) {
    	ArrayList<Equipment> le = new ArrayList<Equipment>(n);
    	
    	Models.containsModel(m);
    	for(Equipment eq: inventory.get(m)) {
    		if(equipmentAvailableAt(eq, p))
    			le.add(eq);
    		if(le.size() == n)
    			return le;
    	}
    	return null;
    }
    
    // User search methods

    /**
     * Looks for the user of the specified id
     * 
     * @param id
     *            the user's id
     * @return the user if found, null otherwise
     */
    public User getUser(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                return users.get(i);
            }
        }
        return null;
    }

    // Loan search methods

    /**
     * Looks for the loans of the given borrower.
     * 
     * @param b
     *            the borrower who made the loans looked for
     * @return an ArrayList of loans
     */
    public ArrayList<Loan> getLoansByBorrower(Borrower b) {
        ArrayList<Loan> loanList = new ArrayList<Loan>();

        for (Loan loan : loans) {
            if (loan.getBorrower().equals(b))
                loanList.add(loan);
        }
        return loanList;
    }

    // Other methods

    /**
     * Counts the total number of elements in the stock.
     * 
     * @return the number of equipments in the inventory
     */
    public int getNumberElements() {
        int number = 0;
        Set<Model> keys = this.inventory.keySet();
        Iterator<Model> it = keys.iterator();
        Model key;

        while (it.hasNext()) {
            key = it.next();
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
        return "loans:\n" + loans + "\ninventory:\n" + inventory + "\nusers:\n"
                + users + "\nasks:\n" + asks;
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

    /**
     * Returns the management system's user list.
     * 
     * @return the value of the users field
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Sets the value of the ArrayList field users with the given ArrayList.
     * 
     * @param lu
     *            the new users value
     */
    public void setUsers(ArrayList<User> lu) {
        users = lu;
    }

    public ArrayList<Ask> getAsks() {
        return asks;
    }

    public void setAsks(ArrayList<Ask> la) {
        asks = la;
    }
}
