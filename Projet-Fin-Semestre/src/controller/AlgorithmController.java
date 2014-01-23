package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JList;

import view.AlgorithmView;
import managementsystem.Loan;
import managementsystem.ManagementSystem;

/**
 * The controller of the algorithm view
 * 
 * @author Hugo SIMOND
 * 
 */
public class AlgorithmController {
    private ManagementSystem ms;
    private AlgorithmView view;
    private List<String> reasons;

    public AlgorithmController(ManagementSystem m, AlgorithmView v) {
        ms = m;
        view = v;
        reasons = new ArrayList<String>();
        v.getOkButton().addActionListener(new OkListener());
        v.getLoansList().addMouseListener(new LoansListener());
        
        HashMap<Loan, String> loansReasons = new HashMap<Loan, String>();
        for(Loan l : loansReasons.keySet()){
            v.getListModel().addElement(l.toString());
            reasons.add(loansReasons.get(l));
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
            view.getReason().setText(reasons.get(selected));
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
