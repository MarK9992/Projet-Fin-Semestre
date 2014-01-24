import managementsystem.ManagementSystem;
import view.AccountView;
import controller.AccountController;


public class TestIHM {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //ManagementSystem ms = new ManagementSystem();
        AccountView v = new AccountView();
        new AccountController(ManagementSystem.getManagementSystem(), v);
    }

}
