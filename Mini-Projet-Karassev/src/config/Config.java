package config;

import java.util.ArrayList;
import java.util.HashMap;

import model.Inventory;
import model.Loan;
import model.equipment.Ipad3;
import model.equipment.Vengeance2100;
import model.equipment.XperiaZ;
import model.users.Manager;
import model.users.Student;
import model.users.Teacher;
import model.users.User;

/**
 * Create the default configuration.
 * @author Anaïs
 *
 */
public class Config {
    public static void main(String[] args) {

        // Create the default inventory for the configuration
        Inventory inventory = new Inventory();
        inventory.addEquipment(new XperiaZ());
        inventory.addEquipment(new XperiaZ());
        inventory.addEquipment(new XperiaZ());
        inventory.addEquipment(new XperiaZ());
        inventory.addEquipment(new XperiaZ());
        inventory.addEquipment(new Ipad3());
        inventory.addEquipment(new Ipad3());
        inventory.addEquipment(new Ipad3());
        inventory.addEquipment(new Ipad3());
        inventory.addEquipment(new Vengeance2100());
        inventory.addEquipment(new Vengeance2100());
        inventory.addEquipment(new Vengeance2100());

        // Create the default student list for the configuration
        ArrayList<User> students = new ArrayList<User>();
        students.add(new Student("S-1", "Ana", new ArrayList<Loan>()));
        students.add(new Student("S-2", "Marc", new ArrayList<Loan>()));
        students.add(new Student("S-3", "Seb", new ArrayList<Loan>()));
        students.add(new Student("S-4", "Mael", new ArrayList<Loan>()));

        // Create the default teacher list for the configuration
        ArrayList<User> teachers = new ArrayList<User>();
        teachers.add(new Teacher("T-1", "MSander", new ArrayList<Loan>()));
        teachers.add(new Teacher("T-2", "MmeLaFaurie", new ArrayList<Loan>()));

        // Create the default managers list for the configuration
        ArrayList<User> managers = new ArrayList<User>();
        managers.add(new Manager("M-1", "Ali"));
        managers.add(new Manager("M-1", "Manager2"));

        // Create the default users dictionnary for the configuration
        HashMap<String, ArrayList<User>> users = new HashMap<String, ArrayList<User>>();
        users.put("managers", managers);
        users.put("students", students);
        users.put("teachers", teachers);

        // Test store the default config
        ConfigXML.store(inventory.getInventory(), "inventory", "v1");
        ConfigXML.store(users, "users", "v1");
    }
}
