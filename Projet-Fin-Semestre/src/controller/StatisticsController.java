package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        // TODO fill the statistics
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
