package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LoansHistoryView extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel loansLabel;
    private JLabel stateLabel;
    private JList<String> loansList;
    private JButton okButton;
    private DefaultListModel<String> listModel;

    /**
     * The view for the borrower's loans history
     */
    public LoansHistoryView() {
        loansLabel = new JLabel("Your loans : ");
        stateLabel = new JLabel();
        listModel = new DefaultListModel<String>();
        okButton = new JButton("OK");
        loansList = new JList<String>(listModel);

        setLayout(new BorderLayout());
        setSize(new Dimension(400, 600));
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(loansLabel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(loansList);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        JPanel statePanel = new JPanel(new BorderLayout());
        statePanel.add(new JLabel("Activated : "), BorderLayout.WEST);
        statePanel.add(stateLabel, BorderLayout.CENTER);
        centerPanel.add(statePanel, BorderLayout.SOUTH);

        JPanel southPanel = new JPanel();
        southPanel.add(okButton);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Getters and setters

    public JButton getOkButton() {
        return okButton;
    }

    public JList<String> getLoansList() {
        return loansList;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }
    
    public JLabel getStateLabel() {
        return stateLabel;
    }
}
