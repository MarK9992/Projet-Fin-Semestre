package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoansHistoryView;
import managementsystem.ManagementSystem;

/**
 * The controller of the Loans history view
 * 
 * @author Hugo SIMOND
 * 
 */
public class LoansHistoryController {
    private ManagementSystem ms;
    private LoansHistoryView view;

    public LoansHistoryController(String idBorrower, ManagementSystem m, LoansHistoryView v) {
        ms = m;
        view = v;
        
        v.getOkButton().addActionListener(new OkListener());
        
        for(int i=0; i<ms.getLoans().size(); i++){
            if(ms.getLoans().get(i).getBorrower().getId().equals(idBorrower)){
                v.getListModel().addElement(ms.getLoans().get(i).toString());
            }
            
            // TODO precise if the loan is accepted
        }
    }

    /**
     * The listener of the ok button
     * 
     * @author Hugo
     * 
     */
    public class OkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }
    }
}
