package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AdministratorView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel borrowingsLabel;
    private JButton validateButton;
    private JButton algoButton;
    private JButton simulationButton;
    private JButton statisticsButton;
    private JButton backButton;
    private DefaultListModel<String> listModel;
    private JList<String> borrowingsList;

    /**
     * The Administrator view
     * 
     * @author Hugo
     */

    public AdministratorView() {
        borrowingsLabel = new JLabel("Loans available : ");
        listModel = new DefaultListModel<String>();
        validateButton = new JButton("Accept loan(s)");
        algoButton = new JButton("Use algorithm");
        simulationButton = new JButton("Simulation");
        statisticsButton = new JButton("Statistics");
        backButton = new JButton("Back");
        borrowingsList = new JList<String>(listModel);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(borrowingsList);

        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel eastPanel = new JPanel(new BorderLayout());
        JPanel northEastPanel = new JPanel(new GridLayout(3,1));
        northEastPanel.add(algoButton);
        northEastPanel.add(simulationButton);
        northEastPanel.add(statisticsButton);
        eastPanel.add(northEastPanel, BorderLayout.NORTH);
        eastPanel.add(backButton, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);

        centerPanel.add(borrowingsLabel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(validateButton, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
        setSize(new Dimension(600, 500));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    /**
     * Displays a message error
     * 
     * @param message
     *            , error to display
     */
    public void errorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Clears the list
     */
    public void clearList() {
        borrowingsList.removeAll();
        listModel.removeAllElements();
    }

    // Getters and setters

    public JLabel getBorrowingsLabel() {
        return borrowingsLabel;
    }

    public JButton getValidateButton() {
        return validateButton;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public JList<String> getBorrowingsList() {
        return borrowingsList;
    }
    
    public JButton getAlgoButton() {
        return algoButton;
    }

    public JButton getSimulationButton() {
        return simulationButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
    
    public JButton getStatisticsButton() {
        return statisticsButton;
    }

}
