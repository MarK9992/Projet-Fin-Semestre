package controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import utils.Statistics;
import view.StatisticsView;
import managementsystem.ManagementSystem;

/**
 * The controller of the Statistics view
 * 
 * @author Hugo SIMOND
 * 
 */
public class StatisticsController {
    private ManagementSystem ms;
    private StatisticsView view;

    public StatisticsController(ManagementSystem m, StatisticsView v) {
        ms = m;
        view = v;

        v.getOkButton().addActionListener(new OkListener());
        Statistics stat = new Statistics(ms);
        v.getCenterPanel().setLayout(new GridLayout(4, 1));
        v.getCenterPanel().add(
                new JLabel("Number of equipments : "
                        + stat.getNumberOfEquipments()));
        v.getCenterPanel().add(
                new JLabel("Number of accepted loans : " + stat.getNumberOfLoans()));
        v.getCenterPanel().add(
                new JLabel("Most borrowed model : "
                        + stat.getMostBorrowedModel()));
        if (stat.getBiggestBorrower() != null) {
            v.getCenterPanel().add(
                    new JLabel("Biggest borrower : "
                            + stat.getBiggestBorrower().getName()));
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
