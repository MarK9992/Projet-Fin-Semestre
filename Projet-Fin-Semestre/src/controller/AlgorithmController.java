package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;

import view.AlgorithmView;
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
        
        // TODO fill JList and List
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
    class LoansListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {
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
