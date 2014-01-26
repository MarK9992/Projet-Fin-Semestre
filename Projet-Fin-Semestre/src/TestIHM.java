import managementsystem.ManagementSystem;
import view.AccountView;
import controller.AccountController;

/**
 * 
 * @author Hugo
 *
 */
public class TestIHM {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AccountView v = new AccountView();
        new AccountController(ManagementSystem.getManagementSystem(), v);
    }

}
