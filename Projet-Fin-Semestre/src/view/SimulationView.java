package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class SimulationView extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel loansLabel;
	private JList<String> loansList;
	private JButton okButton;
	private JButton prevButton;
	private JButton nextButton;
	private JLabel currentDay;
	private DefaultListModel<String> listModel;
	private JLabel state;

	/**
	 * The view for displaying the loans for each day
	 */
	public SimulationView() {
		loansLabel = new JLabel("Loans (click to see the state) : ");
		listModel = new DefaultListModel<String>();
		okButton = new JButton("OK");
		prevButton = new JButton("<<");
		nextButton = new JButton(">>");
		loansList = new JList<String>(listModel);
		loansList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		currentDay = new JLabel();
		currentDay.setHorizontalAlignment(JLabel.CENTER);
		state = new JLabel();

		setLayout(new BorderLayout());
		setSize(new Dimension(400, 600));
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel northPanel = new JPanel(new GridLayout(1, 3));
		northPanel.add(prevButton);
		northPanel.add(currentDay);
		northPanel.add(nextButton);
		add(northPanel, BorderLayout.NORTH);
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(loansLabel, BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(loansList);
		centerPanel.add(scrollPane, BorderLayout.CENTER);
		add(centerPanel, BorderLayout.CENTER);
		JPanel statePanel = new JPanel(new BorderLayout());
		statePanel.add(new JLabel("State : "), BorderLayout.WEST);
		statePanel.add(state, BorderLayout.CENTER);
		centerPanel.add(statePanel, BorderLayout.SOUTH);
		JPanel southPanel = new JPanel();
		southPanel.add(okButton);
		add(southPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	// Getters and setters

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public JLabel getCurrentDay() {
		return currentDay;
	}

	public JLabel getLoansLabel() {
		return loansLabel;
	}

	public JList<String> getLoansList() {
		return loansList;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getPrevButton() {
		return prevButton;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public JLabel getStateLabel() {
		return state;
	}
}
