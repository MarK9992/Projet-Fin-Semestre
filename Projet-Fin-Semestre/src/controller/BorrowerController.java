package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import config.Model;
import config.Models;

import managementsystem.ManagementSystem;
import view.AccountView;
import view.BorrowerView;
import view.CreateLoanView;
import view.LoansHistoryView;

public class BorrowerController {

    private String idBorrower;
    private ManagementSystem ms;
    private BorrowerView view;
    private List<Model> models;

    public BorrowerController(String idBorrower, ManagementSystem m, BorrowerView v) {
        this.idBorrower = idBorrower;
        ms = m;
        view = v;
        view.setTitle(ms.getUser(idBorrower).getName());
        models = new LinkedList<Model>();

        obtainDevicesStrings();

        v.getBorrowButton().addActionListener(new BorrowListener());
        v.getBackButton().addActionListener(new BackListener());
        v.getLoansButton().addActionListener(new LoansListener());
    }
    
    /**
     * The listener of the loans button
     * 
     * @author Hugo
     * 
     */
    public class LoansListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LoansHistoryView newView = new LoansHistoryView();
            new LoansHistoryController(idBorrower, ms, newView);
        }
    }

    /**
     * The listener of the borrow button
     * 
     * @author Hugo
     * 
     */
    public class BorrowListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Model> selected = new LinkedList<Model>();

            for (int i = 0; i < view.getListModel().getSize(); i++) {
                for (int j = 0; j < view.getDevicesList().getSelectedIndices().length; j++) {
                    if (view.getDevicesList().getSelectedIndices()[j] == i) {
                        selected.add(models.get(i));
                    }
                }
            }
            if (selected.isEmpty())
                return;
            CreateLoanView v = new CreateLoanView();
            System.out.println(idBorrower);
            System.out.println(selected);
            System.out.println(ms);
            System.out.println(v);
            new CreateLoanController(idBorrower, selected, ms, v);
        }
    }
    
    /**
     * The listener of the back button
     * 
     * @author Hugo
     * 
     */
    public class BackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AccountView newView = new AccountView();
            new AccountController(ms, newView);
            view.dispose();
        }
    }

    /**
     * Retrieves the ids and labels from the model Adds the labels to the view's
     * list Adds the Ids to the LinkedList
     */
    public void obtainDevicesStrings() {
        models.clear();
        for (Model m : ms.getInventory().keySet()) {
            if(ms.getInventory().get(m).size() == 0){
                continue;
            }
            models.add(Models.getModels().findModelByName(m.getName()));
            view.getListModel().addElement(m.getName());
        }
    }
}
