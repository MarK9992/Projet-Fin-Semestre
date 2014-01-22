package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

    public Borrower borrowerExists(String name, BorrowerType type) {
        for (int i = 0; i < ms.getUsers().size(); i++) {
            if ((ms.getUsers().get(i).getName().equals(name)
                    && ms.getUsers().get(i) instanceof Borrower && ((Borrower) ms
                    .getUsers().get(i)).getType().equals(type))) {
                return (Borrower) ms.getUsers().get(i);
            }
        }
        return null;
    }

    public Manager managerExists(String name, BorrowerType type) {
        for (int i = 0; i < ms.getUsers().size(); i++) {
            if (ms.getUsers().get(i).getName().equals(name)
                    && ms.getUsers().get(i) instanceof Manager) {
                return (Manager) ms.getUsers().get(i);
            }
        }
        return null;
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
            User user;
            if (typeChosen.equals(view.getComboBoxValues()[2])) {
                user = managerExists(name, null);
                System.out.println(user);
                if (user == null) {
                    user = new Manager(name);
                    try {
                        ms.addUser(user);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                AdministratorView v = new AdministratorView();
                new AdministratorController(user.getId(), ms, v);
            } else if (typeChosen.equals(view.getComboBoxValues()[1])) {
                user = borrowerExists(name, BorrowerType.STUDENT);
                System.out.println(user);
                if (user == null) {
                    user = new Borrower(name, BorrowerType.STUDENT);
                    try {
                        ms.addUser(user);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                BorrowerView v = new BorrowerView();
                new BorrowerController(user.getId(), ms, v);
            } else {
                user = borrowerExists(name, BorrowerType.TEACHER);
                System.out.println(user);
                if (user == null) {
                    user = new Borrower(name, BorrowerType.TEACHER);
                    try {
                        ms.addUser(user);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                BorrowerView v = new BorrowerView();
                new BorrowerController(user.getId(), ms, v);
            }

            view.dispose();
        }
    }

}
