package model.users;

/**
 * Super class User, defines all common properties to users.
 * 
 * @author Marc
 * 
 */
public abstract class User {

    // Fields

    private String id;
    private String name;
    private static int counter = 1;

    // Constructors

    public User() {
        this("U", "unknown");
    }

    public User(String i, String n) {
        this.id = i + "-" + counter;
        this.name = n;
        counter++;
    }

    // Methods

    public String toString() {
        return "ID: " + id + ", name: " + name;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static int getCounter() {
        return counter;
    }
}
