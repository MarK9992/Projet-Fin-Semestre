package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import managementsystem.ManagementSystem;

import config.BorrowerType;

import users.Borrower;
import users.Manager;
import users.User;
import view.AccountView;
import view.AdministratorView;
import view.BorrowerView;

/**
 * The controller of the Project
 * 
 * @author Hugo SIMOND
 * 
 */
public class AccountController {
    private ManagementSystem ms;
    private AccountView view;

    public AccountController(ManagementSystem m, AccountView v) {
        ms = m;
        view = v;
        v.getCancelButton().addActionListener(new CancelListener());
        v.getCreateButton().addActionListener(new OkListener());
    }

    /**
     * The listener of the cancel button
     * 
     * @author Hugo
     * 
     */

    public class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }
    }

    /**
     * The listener of the create button
     * 
     * @author Hugo
     * 
     */
    public class OkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameField().getText();
            String typeChosen = view.getTypeComboBox().getSelectedItem()
                    .toString();
            String[] typesAvailable = {"Teacher", "Student", "Administrator"};
            User user;
            if (typeChosen.equals(typesAvailable[2])) {
                user = new Manager(name);
                ms.addUser(user);
                AdministratorView v = new AdministratorView();
                new AdministratorController(user.getId(), ms, v);
            } else if (typeChosen.equals(typesAvailable[1])) {
                user = new Borrower(name, BorrowerType.STUDENT);
                ms.addUser(user);
                BorrowerView v = new BorrowerView();
                new BorrowerController(user.getId(), ms, v);
            } else {
                user = new Borrower(name, BorrowerType.TEACHER);
                ms.addUser(user);
                BorrowerView v = new BorrowerView();
                new BorrowerController(user.getId(), ms, v);
            }
            
            // TODO save the changes
            view.dispose();
        }
    }

}
