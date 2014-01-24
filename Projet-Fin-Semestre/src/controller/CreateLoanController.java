package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.Model;

import managementsystem.Ask;
import managementsystem.ManagementSystem;
import users.Borrower;
import utils.Period;
import view.CreateLoanView;

public class CreateLoanController {
    private String idBorrower;
    private ManagementSystem ms;
    private CreateLoanView view;
    private List<Model> models;

    public CreateLoanController(String idBorrower, List<Model> models,
            ManagementSystem m, CreateLoanView v) {
        this.idBorrower = idBorrower;
        this.models = models;
        ms = m;
        view = v;

        // Setting the listeners
        v.getCancelButton().addActionListener(new CancelListener());
        v.getBorrowButton().addActionListener(new BorrowListener());

        // Fulfillment of the list
        HashMap<String, Integer> labels = new HashMap<String, Integer>();
        for (int i = 0; i < models.size(); i++) {
            labels.put(models.get(i).getName(),ms.getInventory().get(models.get(i)).size());
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
     * @throws IOException 
     * @throws Exception
     *             if the start date is after the end date
     */
    public void borrow(Map<Model, Integer> devices, Date startDate,
            Date endDate) throws IllegalArgumentException, IOException {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        Period p = new Period(start, end);
        Borrower b = (Borrower)ms.getUser(idBorrower);
        Ask l = b.book((HashMap<Model, Integer>)devices, p);
        ms.addAsk(l);
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
            } catch (IOException e1) {
                e1.printStackTrace();
            }

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
