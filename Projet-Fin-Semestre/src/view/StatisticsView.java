package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Displays a window in which the user can create an account
 * 
 * @author Hugo
 * 
 */

public class StatisticsView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton okButton;

    public StatisticsView() {
        okButton = new JButton("OK");
        
        setTitle("Statistics");
        setSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        JPanel southPanel = new JPanel();
        southPanel.add(okButton);
        add(southPanel, BorderLayout.SOUTH);
        JPanel centerPanel = new JPanel(new GridLayout(5,2));
        add(centerPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    // Getters and setters

    public JButton getOkButton() {
        return okButton;
    }
}
