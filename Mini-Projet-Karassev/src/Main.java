import controller.Controller;

/**
 * Main class, launches the program.
 * @author Anaïs
 *
 */
public class Main {

    /**
     * Main method, launches the controller.
     * @param args
     */
    public static void main(String[] args) {
        Controller c = new Controller("inventory", "users", "v1");
        c.startDemo();
    }

}
