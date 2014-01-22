package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import config.Model;

import managementsystem.Loan;
import managementsystem.ManagementSystem;
import users.Borrower;
import utils.Period;
import view.BorrowingView;

public class BorrowingController {
    private String idBorrower;
    private ManagementSystem ms;
    private BorrowingView view;
    private List<Model> models;

    public BorrowingController(String idBorrower, List<Model> models,
            ManagementSystem m, BorrowingView v) {
        this.idBorrower = idBorrower;
        this.models = models;
        ms = m;
        view = v;

        // Setting the listeners
        v.getCancelButton().addActionListener(new CancelListener());
        v.getBorrowButton().addActionListener(new BorrowListener());

        // Fulfillment of the list
        LinkedList<String> labels = new LinkedList<String>();
        for (int i = 0; i < models.size(); i++) {
            labels.add(models.get(i).getName());
        }

        v.fillDevicesList(labels);
    }

    /**
     * Gives the possibility for the borrower to create a borrowing
     * 
     * @param devices
     *            , models to borrow and the number
     * @param startDate
     *            , the start of the borrowing
     * @param endDate
     *            , the end of the borrowing
     * @throws Exception
     *             if the start date is after the end date
     */
    public void borrow(Map<Model, Integer> devices, Date startDate,
            Date endDate) throws IllegalArgumentException {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        Period p = new Period(start, end);
        Borrower b = (Borrower)ms.getUser(idBorrower);
        Loan l = new Loan((HashMap<Model, Integer>)devices, p, b);
        ms.addLoan(l);
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
            Date startDate = view.getDateModelStart().getDate();
            Date endDate = view.getDateModelEnd().getDate();

            Map<Model, Integer> devices = new HashMap<Model, Integer>();
            for (int i = 0; i < models.size(); i++) {
                devices.put(models.get(i), (Integer) view
                        .getNumberModelList().get(i).getValue());
            }

            try {
                borrow(devices, startDate, endDate);
            } catch (IllegalArgumentException e1) {
                view.errorMessage(e1.getMessage());
                return;
            }

            // TODO save the changes
            view.dispose();
        }
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
}
