package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Displays a window in which the user can create an account
 * 
 * @author Hugo
 * 
 */

public class AccountView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel nameLabel;
    private JTextField nameField;
    private JComboBox<String> typeComboBox;
    private JButton createButton;
    private JButton cancelButton;
    private final String[] comboBoxValues = {"Teacher", "Student", "Manager"};

    public AccountView() {
        setTitle("Create Account / Sign in");
        setSize(new Dimension(400, 200));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Name : ");
        nameField = new JTextField();
        typeComboBox = new JComboBox<String>(comboBoxValues);
        createButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        GridLayout mainLayout = new GridLayout(3, 1);
        setLayout(mainLayout);

        JPanel topPanel = new JPanel();
        GridLayout topLayout = new GridLayout(2, 2);
        topPanel.setLayout(topLayout);
        topPanel.add(nameLabel);
        topPanel.add(nameField);
        add(topPanel);

        JPanel centerPanel = new JPanel();
        centerPanel.add(typeComboBox);
        add(centerPanel);

        JPanel botPanel = new JPanel();
        GridLayout botLayout = new GridLayout(1, 2);
        botPanel.setLayout(botLayout);
        JPanel botLeftPan = new JPanel();
        JPanel botRightPan = new JPanel();
        botPanel.add(botLeftPan);
        botPanel.add(botRightPan);
        botLeftPan.add(createButton);
        botRightPan.add(cancelButton);
        add(botPanel);

        setVisible(true);
    }

    // Getters and setters

    public JTextField getNameField() {
        return nameField;
    }

    public JComboBox<String> getTypeComboBox() {
        return typeComboBox;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
    
    public String[] getComboBoxValues() {
        return comboBoxValues;
    }

}
