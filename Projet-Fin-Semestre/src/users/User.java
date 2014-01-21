package users;

/**
 * Super class User, defines all common properties to users.
 * 
 * initial code by: Marc Karassev; modified by: Marc Karassev
 * 
 * @author Marc Karassev
 * 
 */
public abstract class User {

	// Fields

	private String id;
	private String name;
	private static int counter = 1;

	// Constructors

	/**
	 * Default constructor, constructs a new user named "unknown".
	 */
	public User() {
		this("U", "unknown");
	}

	/**
	 * Constructs a new user with the specified name and id.
	 * 
	 * @param i
	 *            the id of the new user
	 * @param n
	 *            the name of the new user
	 */
	public User(String i, String n) {
		id = i + "-" + counter;
		name = n;
		counter++;
	}

	// Methods

	/**
	 * Returns a string representation of this user and its values.
	 */
	@Override
	public String toString() {
		return "ID: " + id + ", name: " + name;
	}

	// Getters and setters

	/**
	 * Returns the id field.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the name field
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the user counter.
	 * 
	 * @return the user counter
	 */
	public static int getCounter() {
		return counter;
	}
}
