package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JList;

import view.LoansHistoryView;
import managementsystem.Loan;
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
    private List<Loan> loans;

    public LoansHistoryController(String idBorrower, ManagementSystem m, LoansHistoryView v) {
        ms = m;
        view = v;
        
        v.getOkButton().addActionListener(new OkListener());
        v.getLoansList().addMouseListener(new LoansListener());
        for(int i=0; i<ms.getLoans().size(); i++){
            if(ms.getLoans().get(i).getBorrower().getId().equals(idBorrower)){
                v.getListModel().addElement(ms.getLoans().get(i).toString());
                loans.add(ms.getLoans().get(i));
            }
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
    
    /**
     * The listener of the list
     * 
     * @author Hugo
     * 
     */
    public class LoansListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {
            if(view.getListModel().getSize() == 0){
                return;
            }
            JList<String> list = view.getLoansList();
            int selected = list.getSelectedIndex();
            String state;
            if(loans.get(selected).isAccepted()){
                state = "yes";
            }else{
                state = "no";
            }
            view.getStateLabel().setText(state);
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {}

        @Override
        public void mouseExited(MouseEvent arg0) {}

        @Override
        public void mousePressed(MouseEvent arg0) {}

        @Override
        public void mouseReleased(MouseEvent arg0) {}
    }
}
